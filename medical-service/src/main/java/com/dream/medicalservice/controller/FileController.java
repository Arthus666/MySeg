package com.dream.medicalservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dream.medicalservice.consumer.UserClient;
import com.dream.medicalservice.entity.Directory;
import com.dream.medicalservice.entity.Latest;
import com.dream.medicalservice.entity.Result;
import com.dream.medicalservice.enumeration.ResultCode;
import com.dream.medicalservice.service.IDirectoryService;
import com.dream.medicalservice.service.IFileService;
import com.dream.medicalservice.utils.RedisUtil;
import com.dream.medicalservice.utils.UnitConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Arthus
 * @since 2023-03-10
 */
@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserClient userClient;

    @Autowired
    private IFileService fileService;

    @Autowired
    private IDirectoryService directoryService;

    @GetMapping("/hello")
    public String hello(@RequestAttribute("user_id") Integer user_id) {
        logger.info("Hello,用户：" + user_id);
        return "hello";
    }

    @PostMapping("/fileUpload")
    public Result fileUpload(@RequestAttribute("user_id") Integer user_id,
                             @RequestParam("father_dirctory_id") String father_dirctory_id,
                             @RequestParam("medical_status") String medical_status,
                             @RequestParam("medical_model") String medical_model,
                             @RequestParam("medical_file") MultipartFile medical_file) throws IOException {

        //若文件参数为空
        if (user_id == null || father_dirctory_id == null || medical_status == null && medical_file == null) {
            return new Result(ResultCode.FILE_ISNULL.code, ResultCode.FILE_ISNULL.msg);
        }

        //若文件分割状态不正确
        if ("segmented".equals(medical_status) == false && "unsegmented".equals(medical_status) == false) {
            return new Result(ResultCode.FILE_STATUS_INCORRECT.code, ResultCode.FILE_STATUS_INCORRECT.msg);
        }

        //若文件父目录不存在
        if ("0".equals(father_dirctory_id) == false && directoryService.getById(father_dirctory_id) == null) {
            return new Result(ResultCode.FILE_DIRECTORY_NOT_EXIST.code, ResultCode.FILE_DIRECTORY_NOT_EXIST.msg);
        }

        //获取文件原名
        String file_original_name = medical_file.getOriginalFilename();

        //处理文件重名问题
        String file_suffix = file_original_name.substring(file_original_name.indexOf("."));

        String file_name = UUID.randomUUID() + file_suffix;

        File user_file;

        String father_path = "E:\\MedicalService\\UserFiles";

        if ("segmented".equals(medical_status)) {

            //获取保存路径
            user_file = new File(father_path + File.separator + "User_" + user_id + File.separator + "segmented");

            if (!user_file.exists()) {
                user_file.mkdirs();
            }

            String file_path = father_path + File.separator + "User_" + user_id + File.separator + "segmented" + File.separator + file_name;

            //上传到指定路径
            medical_file.transferTo(new File(file_path));

            //格式化当前日期和时间
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String file_time = dateFormat.format(new Date(System.currentTimeMillis()));

            //生成下载文件的链接
            String file_link = "/medical/fileDownload/segmented/" + file_original_name + "/" + file_name;

            //将文件字节大小转换为B,KB,MB,GB
            String file_size = UnitConverter.convert(medical_file.getSize());

            //在数据库中保存file的信息
            fileService.save(new com.dream.medicalservice.entity.File(0, user_id, file_original_name, (byte) 1, file_size, file_suffix, medical_model, file_time, file_path, file_link));

            //获取数据库中文件id
            com.dream.medicalservice.entity.File file = fileService.getFileByFileLink(file_link);

            //在数据库中保存file的父目录信息
            if ("0".equals(father_dirctory_id)) {
                directoryService.save(new Directory(0, user_id, file_original_name, 0, file.getFileId(), file_link, file.getFileStatus(), file.getFileModel(), file.getFileTime()));
            } else {
                directoryService.save(new Directory(0, user_id, file_original_name, Integer.valueOf(father_dirctory_id), file.getFileId(), file_link, file.getFileStatus(), file.getFileModel(), file.getFileTime()));
            }

            logger.info("保存文件：user_id={},filename={},file_status={},file_size={},file_suffix={},file_time={},file_path={},file_link={}", user_id, file_original_name, medical_status, file_size, file_suffix, file_time, file_path, file_link);

            return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, file.getFileId());

        } else {

            //获取保存路径
            user_file = new File(father_path + File.separator + "User_" + user_id + File.separator + "unsegmented");

            if (!user_file.exists()) {
                user_file.mkdirs();
            }

            String file_path = father_path + File.separator + "User_" + user_id + File.separator + "unsegmented" + File.separator + file_name;

            //上传到指定路径
            medical_file.transferTo(new File(file_path));

            //格式化当前日期和时间
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String file_time = dateFormat.format(new Date(System.currentTimeMillis()));

            //生成下载文件的链接
            String file_link = "/medical/fileDownload/unsegmented/" + file_original_name + "/" + file_name;

            //将文件字节大小转换为B,KB,MB,GB
            String file_size = UnitConverter.convert(medical_file.getSize());

            //在数据库中保存file的信息
            fileService.save(new com.dream.medicalservice.entity.File(0, user_id, file_original_name, (byte) 0, file_size, file_suffix, null, file_time, file_path, file_link));

            //获取数据库中文件id
            com.dream.medicalservice.entity.File file = fileService.getFileByFileLink(file_link);

            //在数据库中保存file的父目录信息
            if ("0".equals(father_dirctory_id)) {
                directoryService.save(new Directory(0, user_id, file_original_name, 0, file.getFileId(), file_link, file.getFileStatus(), file.getFileModel(), file.getFileTime()));
            } else {
                directoryService.save(new Directory(0, user_id, file_original_name, Integer.valueOf(father_dirctory_id), file.getFileId(), file_link, file.getFileStatus(), file.getFileModel(), file.getFileTime()));
            }

            logger.info("保存文件：user_id={},filename={},file_status={},file_size={},file_suffix={},file_time={},file_path={},file_link={}", user_id, file_original_name, medical_status, file_size, file_suffix, file_time, file_path, file_link);

            return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, file.getFileId());
        }

    }

    @GetMapping("/fileDownload/{medical_status}/{file_original_name}/{file_name}")
    public ResponseEntity fileDownload(@RequestAttribute("user_id") Integer user_id,
                                       @PathVariable("medical_status") String medical_status,
                                       @PathVariable("file_original_name") String file_original_name,
                                       @PathVariable("file_name") String file_name) throws IOException {

        //若文件参数为空
        if (user_id == null || medical_status == null || file_original_name == null || file_name == null) {
            return null;
        }

        //若文件分割状态不正确
        if ("segmented".equals(medical_status) == false && "unsegmented".equals(medical_status) == false && "extracted".equals(medical_status) == false) {
            return null;
        }

        //文件路径
        String file_path = "E:\\MedicalService\\UserFiles\\User_" + user_id + File.separator + medical_status + File.separator + file_name;

        //创建输入流
        InputStream inputStream = new FileInputStream(file_path);

        //创建字节数组
        byte[] bytes = new byte[inputStream.available()];

        //将流读到字节数组中
        inputStream.read(bytes);

        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();

        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=" + file_original_name);

        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;

        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);

        inputStream.close();

        return responseEntity;
    }

    @DeleteMapping("/fileDelete/{file_id}")
    public Result fileDelete(@RequestAttribute("user_id") Integer user_id,
                             @PathVariable("file_id") String file_id) {

        if (user_id == null || file_id == null) {
            return new Result(ResultCode.INPUT_ISNULL.code, ResultCode.INPUT_ISNULL.msg);
        } else {
            com.dream.medicalservice.entity.File user_file = fileService.getById(file_id);

            if (user_file == null || user_id.equals(user_file.getUserId()) == false) {
                return new Result(ResultCode.USER_ID_MISMATCH.code, ResultCode.USER_ID_MISMATCH.msg);
            }

            //删除磁盘中的文件
            File file = new File(user_file.getFilePath());

            if (file.exists() && file.isFile()) {
                file.delete();
            }

            //删除数据库中的记录
            fileService.removeById(file_id);

            directoryService.removeFileDirctory(Integer.valueOf(file_id));

            return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg);
        }

    }

    @PutMapping("/moveFile/{file_id}/{new_parent_id}")
    public Result moveFile(@RequestAttribute("user_id") Integer user_id,
                           @PathVariable("file_id") String file_id,
                           @PathVariable("new_parent_id") String new_parent_id) {

        if (user_id == null || file_id == null || new_parent_id == null) {
            return new Result(ResultCode.INPUT_ISNULL.code, ResultCode.INPUT_ISNULL.msg);
        }

        com.dream.medicalservice.entity.File file = fileService.getById(file_id);
        Directory directory = directoryService.getById(new_parent_id);

        if (file == null || directory == null && "0".equals(new_parent_id) == false) {
            return new Result(ResultCode.FILE_OR_DIRECTORY_NOT_FOUND.code, ResultCode.FILE_OR_DIRECTORY_NOT_FOUND.msg);
        } else if (user_id.equals(file.getUserId()) == false || directory != null && user_id.equals(directory.getUser_id()) == false) {
            return new Result(ResultCode.USER_ID_NOT_THE_SAME.code, ResultCode.USER_ID_NOT_THE_SAME.msg);
        } else if (directory != null && directory.getDirectoryIsFile().equals(0) == false) {
            return new Result(ResultCode.DIRECTORY_IS_FILE.code, ResultCode.DIRECTORY_IS_FILE.msg);
        } else {
            directoryService.moveFileDirectory(new_parent_id, file_id);
        }
        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg);
    }

    @PutMapping("/copyFile/{file_id}/{new_parent_id}")
    public Result copyFile(@RequestAttribute("user_id") Integer user_id,
                           @PathVariable("file_id") String file_id,
                           @PathVariable("new_parent_id") String new_parent_id) {

        if (user_id == null || file_id == null || new_parent_id == null) {
            return new Result(ResultCode.INPUT_ISNULL.code, ResultCode.INPUT_ISNULL.msg);
        }

        com.dream.medicalservice.entity.File file = fileService.getById(file_id);
        Directory directory = directoryService.getById(new_parent_id);

        if (file == null || directory == null && "0".equals(new_parent_id) == false) {
            return new Result(ResultCode.FILE_OR_DIRECTORY_NOT_FOUND.code, ResultCode.FILE_OR_DIRECTORY_NOT_FOUND.msg);
        } else if (user_id.equals(file.getUserId()) == false || directory != null && user_id.equals(directory.getUser_id()) == false) {
            return new Result(ResultCode.USER_ID_NOT_THE_SAME.code, ResultCode.USER_ID_NOT_THE_SAME.msg);
        } else if (directory != null && directory.getDirectoryIsFile().equals(0) == false) {
            return new Result(ResultCode.DIRECTORY_IS_FILE.code, ResultCode.DIRECTORY_IS_FILE.msg);
        } else {

            //获取原文件路径
            String source_path = file.getFilePath();
            String[] nodes = source_path.split("\\\\");
            String source_name = nodes[nodes.length - 1];
            String dest_name = UUID.randomUUID() + file.getFileType();

            //生成新文件路径
            String dest_path = source_path.replace(source_name, dest_name);

            logger.info("文件复制至：{}" + dest_path);

            try (FileChannel in = new FileInputStream(source_path).getChannel(); FileChannel out = new FileOutputStream(dest_path).getChannel()) {
                out.transferFrom(in, 0, in.size());
                logger.info("文件复制成功");
            } catch (IOException e) {
                logger.warn("文件复制失败");
                e.printStackTrace();
            }

            //格式化当前日期和时间
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String file_time = dateFormat.format(new Date(System.currentTimeMillis()));

            String file_link;

            //生成下载文件的链接
            if (file.getFileStatus().equals(1)) {
                file_link = "/medical/fileDownload/segmented/" + file.getFileName() + "/" + dest_name;
            } else {
                file_link = "/medical/fileDownload/unsegmented/" + file.getFileName() + "/" + dest_name;
            }

            //在数据库中保存file的信息
            fileService.save(new com.dream.medicalservice.entity.File(0, user_id, file.getFileName(), file.getFileStatus(), file.getFileSize(), file.getFileType(), file.getFileModel(), file_time, dest_path, file_link));

            //获取数据库中文件id
            com.dream.medicalservice.entity.File new_file = fileService.getFileByFileLink(file_link);

            //在数据库中保存file的父目录信息
            if ("0".equals(new_parent_id)) {
                directoryService.save(new Directory(0, user_id, file.getFileName(), 0, new_file.getFileId(), file_link, new_file.getFileStatus(), new_file.getFileModel(), new_file.getFileTime()));
            } else {
                directoryService.save(new Directory(0, user_id, file.getFileName(), Integer.valueOf(new_parent_id), new_file.getFileId(), file_link, new_file.getFileStatus(), new_file.getFileModel(), new_file.getFileTime()));

                logger.info("保存文件：user_id={},filename={},file_status={},file_size={},file_suffix={},file_time={},file_path={},file_link={}", user_id, new_file.getFileName(), new_file.getFileStatus(), new_file.getFileSize(), new_file.getFileType(), file_time, dest_path, file_link);

            }
            return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg);
        }

    }

    @GetMapping("/getLatestFunctionAndFile")
    public Result getLatestFunctionAndFile(@RequestAttribute("user_id") Integer user_id) {

        if (user_id == null) {
            return new Result(ResultCode.INPUT_ISNULL.code, ResultCode.INPUT_ISNULL.msg);
        }

        if (redisUtil.get("User_" + user_id + "_latest_function") != null && redisUtil.get("User_" + user_id + "_latest_file_id") != null) {

            String latest_function = redisUtil.get("User_" + user_id + "_latest_function").toString();
            String latest_file_id = redisUtil.get("User_" + user_id + "_latest_file_id").toString();

            com.dream.medicalservice.entity.File file = fileService.getById(latest_file_id);

            return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, new Latest(latest_function, file));

        } else {
            return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg);
        }


    }

    @GetMapping("/getUsageCount")
    public Result getUsageCount(@RequestAttribute("user_id") Integer user_id) {
        return userClient.getUsageCount(user_id);
    }

    @GetMapping("/getUserHistory")
    public Result getUserHistory(@RequestAttribute("user_id") Integer user_id) {
        return userClient.getUserHistory(user_id);
    }

    @GetMapping("/getTotalCount")
    public Result getFunctionsCount() {
        return userClient.getTotalCount();
    }


    @PutMapping("/usageCount/{latest_function}/{latest_file_id}")
    public Result usageCount(@RequestAttribute("user_id") Integer user_id,
                             @PathVariable("latest_function") String latest_function,
                             @PathVariable("latest_file_id") String latest_file_id) {

        return userClient.usageCount(user_id, latest_function, latest_file_id);
    }

    @GetMapping("/getFileInfo/{file_id}")
    public Result getFileInfo(@RequestAttribute("user_id") Integer user_id,
                              @PathVariable("file_id") String file_id) {

        if (user_id == null || file_id == null) {
            return new Result(ResultCode.INPUT_ISNULL.code, ResultCode.INPUT_ISNULL.msg);
        }

        com.dream.medicalservice.entity.File file = fileService.getById(file_id);

        if (file == null) {
            return new Result(ResultCode.FILE_NOT_FOUND.code, ResultCode.FILE_NOT_FOUND.msg);
        }
        if (user_id.equals(file.getUserId()) == false) {
            return new Result(ResultCode.USER_ID_MISMATCH.code, ResultCode.USER_ID_MISMATCH.msg);
        }

        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, file);

    }

    @GetMapping("/searchFile/{file_name}")
    public Result searchFile(@RequestAttribute("user_id") Integer user_id,
                             @PathVariable("file_name") String file_name) {

        QueryWrapper<com.dream.medicalservice.entity.File> wrapper = new QueryWrapper<>();

        wrapper.eq("user_id", user_id);
        wrapper.like("file_name", file_name);

        List<com.dream.medicalservice.entity.File> list = fileService.list(wrapper);

        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, list);
    }

    @GetMapping("/file_record")
    public Result file_record(@RequestAttribute("user_id") Integer user_id) {
        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.code, fileService.getFileRecord(user_id));
    }

}

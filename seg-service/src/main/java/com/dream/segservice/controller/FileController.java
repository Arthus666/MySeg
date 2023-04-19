package com.dream.segservice.controller;

import com.dream.segservice.entity.Directory;
import com.dream.segservice.entity.Result;
import com.dream.segservice.enumeration.ResultCode;
import com.dream.segservice.service.impl.DirectoryServiceImpl;
import com.dream.segservice.service.impl.FileServiceImpl;
import com.dream.segservice.utils.Extract;
import com.dream.segservice.utils.UnitConverter;
import com.dream.segservice.utils.VnetSeg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Arthus
 * @since 2023-03-30
 */
@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileServiceImpl fileService;

    @Autowired
    private DirectoryServiceImpl directoryService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello,Arthus!";
    }

    @GetMapping("/vnet_segment/{file_id}")
    public Result vnet_segment(@RequestAttribute("user_id") Integer user_id,
                               @PathVariable("file_id") String file_id) {

        if (user_id == null || file_id == null) {
            return new Result(ResultCode.INPUT_ISNULL.code, ResultCode.INPUT_ISNULL.msg);
        }

        com.dream.segservice.entity.File file = fileService.getById(file_id);

        if (file == null) {
            return new Result(ResultCode.FILE_NOT_FOUND.code, ResultCode.FILE_NOT_FOUND.msg);
        }
        if (user_id.equals(file.getUserId()) == false) {
            return new Result(ResultCode.USERID_MISMATCH.code, ResultCode.USERID_MISMATCH.msg);
        }
        if (file.getFileStatus() != 0) {
            return new Result(ResultCode.FILE_SEGMENTED.code, ResultCode.FILE_SEGMENTED.msg);
        }

        String segment_path = VnetSeg.segment(file.getFilePath());

        File segmented_file = new File(segment_path);

        //生成下载文件的链接
        String file_link = "/medical/fileDownload/segmented/" + file.getFileName() + "/" + segment_path.substring(segment_path.lastIndexOf('\\') + 1);

        //格式化当前日期和时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String file_time = dateFormat.format(new Date(System.currentTimeMillis()));

        //将文件字节大小转换为B,KB,MB,GB
        String file_size = UnitConverter.convert(segmented_file.length());

        //在数据库中保存file的信息
        fileService.save(new com.dream.segservice.entity.File(0, Integer.valueOf(user_id), file.getFileName(), (byte) 1, file_size, file.getFileType(), "vnet", file_time, segment_path, file_link));

        com.dream.segservice.entity.File segmented_user_file = fileService.getFileByFileLink(file_link);

        directoryService.save(new Directory(0, Integer.valueOf(user_id), file.getFileName(), 0, segmented_user_file.getFileId(), file_link, segmented_user_file.getFileStatus(), segmented_user_file.getFileModel(), segmented_user_file.getFileTime()));

        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, segmented_user_file);

    }

    @PostMapping("/upload_and_vnet_segment")
    public Result upload_and_vnet_segment(@RequestAttribute("user_id") Integer user_id,
                                          @RequestParam("medical_model") String medical_model,
                                          @RequestParam("medical_file") MultipartFile medical_file) throws IOException {

        //若文件参数为空
        if (user_id == null || medical_file == null) {
            return new Result(ResultCode.FILE_ISNULL.code, ResultCode.FILE_ISNULL.msg);
        }

        //获取文件原名
        String file_original_name = medical_file.getOriginalFilename();

        //处理文件重名问题
        String file_suffix = file_original_name.substring(file_original_name.indexOf("."));

        String file_name = UUID.randomUUID() + file_suffix;

        File user_file;

        String father_path = "E:\\MedicalService\\UserFiles";

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
        fileService.save(new com.dream.segservice.entity.File(0, user_id, file_original_name, (byte) 0, file_size, file_suffix, medical_model, file_time, file_path, file_link));

        //获取数据库中文件id
        com.dream.segservice.entity.File unsegmented_user_file = fileService.getFileByFileLink(file_link);

        //在数据库中保存file的父目录信息
        directoryService.save(new Directory(0, user_id, file_original_name, 0, unsegmented_user_file.getFileId(), file_link, unsegmented_user_file.getFileStatus(), unsegmented_user_file.getFileModel(), unsegmented_user_file.getFileTime()));

        logger.info("保存文件：user_id={},filename={},file_status={},file_size={},file_suffix={},file_time={},file_path={},file_link={}", user_id, file_original_name, 0, file_size, file_suffix, file_time, file_path, file_link);

        com.dream.segservice.entity.File file = fileService.getById(unsegmented_user_file.getFileId());

        if (file == null) {
            return new Result(ResultCode.FILE_NOT_FOUND.code, ResultCode.FILE_NOT_FOUND.msg);
        }
        if (user_id.equals(file.getUserId()) == false) {
            return new Result(ResultCode.USERID_MISMATCH.code, ResultCode.USERID_MISMATCH.msg);
        }
        if (file.getFileStatus() != 0) {
            return new Result(ResultCode.FILE_SEGMENTED.code, ResultCode.FILE_SEGMENTED.msg);
        }

        String segment_path = VnetSeg.segment(file.getFilePath());

        File segmented_file = new File(segment_path);

        //生成下载文件的链接
        String segmented_file_link = "/medical/fileDownload/segmented/" + file.getFileName() + "/" + segment_path.substring(segment_path.lastIndexOf('\\') + 1);

        //格式化当前日期和时间
        SimpleDateFormat segmented_dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String segmented_file_time = segmented_dateFormat.format(new Date(System.currentTimeMillis()));

        //将文件字节大小转换为B,KB,MB,GB
        String segmented_file_size = UnitConverter.convert(segmented_file.length());

        //在数据库中保存file的信息
        fileService.save(new com.dream.segservice.entity.File(0, Integer.valueOf(user_id), file.getFileName(), (byte) 1, segmented_file_size, file.getFileType(), "vnet", segmented_file_time, segment_path, segmented_file_link));

        com.dream.segservice.entity.File segmented_user_file = fileService.getFileByFileLink(segmented_file_link);

        directoryService.save(new Directory(0, Integer.valueOf(user_id), file.getFileName(), 0, segmented_user_file.getFileId(), segmented_file_link, segmented_user_file.getFileStatus(), segmented_user_file.getFileModel(), segmented_user_file.getFileTime()));

        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, segmented_user_file);
    }

    @GetMapping("/extract/{file_id}")
    public Result extract(@RequestAttribute("user_id") Integer user_id,
                          @PathVariable("file_id") String file_id) {

        if (user_id == null || file_id == null) {
            return new Result(ResultCode.INPUT_ISNULL.code, ResultCode.INPUT_ISNULL.msg);
        }

        com.dream.segservice.entity.File file = fileService.getById(file_id);

        if (file == null) {
            return new Result(ResultCode.FILE_NOT_FOUND.code, ResultCode.FILE_NOT_FOUND.msg);
        }
        if (user_id.equals(file.getUserId()) == false) {
            return new Result(ResultCode.USERID_MISMATCH.code, ResultCode.USERID_MISMATCH.msg);
        }
        if (file.getFileStatus() != 1) {
            return new Result(ResultCode.FILE_UNSEGMENTED.code, ResultCode.FILE_UNSEGMENTED.msg);
        }

        String extract_path = Extract.extract(file.getFilePath());

        File extract_file = new File(extract_path);

        //生成下载文件的链接
        String file_link = "/medical/fileDownload/extracted/" + file.getFileName() + "/" + extract_path.substring(extract_path.lastIndexOf('\\') + 1);

        //格式化当前日期和时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String file_time = dateFormat.format(new Date(System.currentTimeMillis()));

        //将文件字节大小转换为B,KB,MB,GB
        String file_size = UnitConverter.convert(extract_file.length());

        //在数据库中保存file的信息
        fileService.save(new com.dream.segservice.entity.File(0, Integer.valueOf(user_id), file.getFileName(), (byte) 1, file_size, file.getFileType(), file.getFileModel(), file_time, extract_path, file_link));

        com.dream.segservice.entity.File extracted_file = fileService.getFileByFileLink(file_link);

        directoryService.save(new Directory(0, Integer.valueOf(user_id), file.getFileName(), 0, extracted_file.getFileId(), file_link, extracted_file.getFileStatus(), extracted_file.getFileModel(), extracted_file.getFileTime()));

        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, extracted_file);

    }

}

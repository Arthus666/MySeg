package com.dream.adminservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dream.adminservice.common.Result;
import com.dream.adminservice.common.ResultCode;
import com.dream.adminservice.mapper.FileMapper;
import com.dream.adminservice.pojo.File;
import com.dream.adminservice.pojo.User;
import com.dream.adminservice.service.FileService;
import com.dream.adminservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;

    @Autowired
    private FileMapper fileMapper;

    /**
     * 根据用户Id查询用户所有的文件 (分页显示)
     *
     * @return
     */
    @GetMapping("/findByUserID/{userId}")
    public Result<Map> list(@PathVariable Integer userId,
                                   @RequestParam(defaultValue = "1") int page,
                                   @RequestParam(defaultValue = "10") int size) {
        QueryWrapper<File> qw = new QueryWrapper();
        qw.eq("user_id", userId);//相当于where id=1
        Page<File> page1 = new Page<>(page, size);
        Page<File> filePage = fileMapper.selectPage(page1, qw);
        List<File> files = filePage.getRecords();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("total",files.size());
        map.put("items",files);
        return new Result<Map>(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, map);
    }

    /**
     * 新建文件
     *
     * @param file
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody File file,
                      @RequestParam String userName,
                      @RequestParam("medical_file") MultipartFile medical_file) {
        User user = userService.getOne(userName);
        file.setFileTime(LocalDateTime.now().toString());
        file.setUserId(user.getUserId());
        fileService.save(file);
        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg);
    }

    /**
     * 修改文件信息
     *
     * @param file
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody File file) {
        file.setFileTime(LocalDateTime.now().toString());
        System.out.println("aaa");
        fileService.updateById(file);
        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg);
    }

    /**
     * 根据fileId删除
     * @param fileId
     * @return
     */
    @DeleteMapping("/delete/{fileId}")
    public Result delete(@PathVariable Long fileId) {

        QueryWrapper<File> qw = new QueryWrapper<>();
        qw.eq("file_id",fileId);
        File file = fileService.getOne(qw);
        String filePath = file.getFilePath();
        System.out.println(filePath);
        java.io.File file1 = new java.io.File(filePath);
        if( file1.exists() && file1.isFile())
            file1.delete();
        fileService.removeById(fileId);
        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg);
    }

    /**
     * 根据条件查询
     *
     * @param page
     * @param size
     * @param userName
     * @param fileModel
     * @param fileStatus
     * @param fileType
     * @return
     */
    @GetMapping("/list")
    public Result<Map> listByCondition(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "") String userName,
            @RequestParam(defaultValue = "") String fileModel,
            @RequestParam(defaultValue = "") Integer fileStatus,
            @RequestParam(defaultValue = "") String fileType
    ) throws UnsupportedEncodingException {

        userName = URLDecoder.decode(userName, String.valueOf(StandardCharsets.UTF_8));
        System.out.println(userName);
        User user = userService.getOne(userName);
        if(user == null && userName!= null && userName.length() != 0)
            return new Result<Map>(ResultCode.USER_IS_NOT_EXTENT.code,ResultCode.USER_IS_NOT_EXTENT.msg,null);
        QueryWrapper<File> qw2 = new QueryWrapper();
        if (fileModel != null && fileModel.length() > 0)
            qw2.eq("file_model", fileModel);
        if (fileStatus != null)
            qw2.eq("file_status", fileStatus);
        if (fileType != null && fileType.length() > 0)
            qw2.eq("file_type", fileType);
        if (user != null)
            qw2.eq("user_id", user.getUserId());
        Page<File> page1 = new Page<>(page, size);
        Page<File> filePage = fileMapper.selectPage(page1, qw2);
        List<File> files = filePage.getRecords();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("total",files.size());
        map.put("items",files);
        return new Result<Map>(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, map);
    }

}

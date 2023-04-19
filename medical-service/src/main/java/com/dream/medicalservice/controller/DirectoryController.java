package com.dream.medicalservice.controller;

import com.dream.medicalservice.entity.Directory;
import com.dream.medicalservice.entity.File;
import com.dream.medicalservice.entity.Result;
import com.dream.medicalservice.enumeration.ResultCode;
import com.dream.medicalservice.service.IDirectoryService;
import com.dream.medicalservice.service.IFileService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Insert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Arthus
 * @since 2023-03-11
 */
@RestController
public class DirectoryController {

    private static final Logger logger = LoggerFactory.getLogger(DirectoryController.class);

    @Autowired
    private IDirectoryService directoryService;

    @Autowired
    private IFileService fileService;

    @GetMapping("/createDirectory/{father_directory_id}/{directory_name}")
    public Result createDirectory(@RequestAttribute("user_id") Integer user_id,
                                  @PathVariable("father_directory_id") String father_directory_id,
                                  @PathVariable("directory_name") String directory_name) {

        Directory directory = directoryService.getById(father_directory_id);

        if (directory == null && "0".equals(father_directory_id) == false) {
            return new Result(ResultCode.FILE_OR_DIRECTORY_NOT_FOUND.code, ResultCode.FILE_OR_DIRECTORY_NOT_FOUND.msg);
        } else if (directory != null && user_id.equals(directory.getUser_id()) == false) {
            return new Result(ResultCode.USER_ID_NOT_THE_SAME.code, ResultCode.USER_ID_NOT_THE_SAME.msg);
        } else if (directory != null && directory.getDirectoryIsFile().equals(0) == false) {
            return new Result(ResultCode.DIRECTORY_IS_FILE.code, ResultCode.DIRECTORY_IS_FILE.msg);
        } else {
            directoryService.save(new Directory(0, user_id, directory_name, Integer.valueOf(father_directory_id), 0, null,null,null,null));
            return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg);
        }

    }

    @PutMapping("/updateDirectoryName/{directory_id}/{directory_name}")
    public Result updateDirectoryName(@RequestAttribute("user_id") Integer user_id,
                                      @PathVariable("directory_id") String directory_id,
                                      @PathVariable("directory_name") String directory_name) {

        Directory directory = directoryService.getById(directory_id);

        if (directory == null) {
            return new Result(ResultCode.FILE_OR_DIRECTORY_NOT_FOUND.code, ResultCode.FILE_OR_DIRECTORY_NOT_FOUND.msg);
        } else if (user_id.equals(directory.getUser_id()) == false) {
            return new Result(ResultCode.USER_ID_NOT_THE_SAME.code, ResultCode.USER_ID_NOT_THE_SAME.msg);
        } else if (directory.getDirectoryIsFile().equals(0) == false) {
            return new Result(ResultCode.DIRECTORY_IS_FILE.code, ResultCode.DIRECTORY_IS_FILE.msg);
        } else {
            directoryService.updateDirectoryName(directory_name, directory_id);
            return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg);
        }

    }

    @GetMapping("/getDirectoriesAndFiles/{directory_id}")
    public Result getDirectoriesAndFiles(@RequestAttribute("user_id") Integer user_id,
                                         @PathVariable("directory_id") String directory_id) {

        Directory directory = directoryService.getById(directory_id);

        if (directory == null && "0".equals(directory_id) == false) {
            return new Result(ResultCode.FILE_OR_DIRECTORY_NOT_FOUND.code, ResultCode.FILE_OR_DIRECTORY_NOT_FOUND.msg);
        } else if (directory != null && user_id.equals(directory.getUser_id()) == false) {
            return new Result(ResultCode.USER_ID_NOT_THE_SAME.code, ResultCode.USER_ID_NOT_THE_SAME.msg);
        } else if (directory != null && directory.getDirectoryIsFile().equals(0) == false) {
            return new Result(ResultCode.DIRECTORY_IS_FILE.code, ResultCode.DIRECTORY_IS_FILE.msg);
        } else {
            return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, directoryService.selectDirectoriesAndFiles(directory_id, user_id.toString()));
        }

    }

    @GetMapping("/getDirectories/{directory_id}")
    public Result getDirectories(@RequestAttribute("user_id") Integer user_id,
                                 @PathVariable("directory_id") String directory_id) {

        Directory directory = directoryService.getById(directory_id);

        if (directory == null && "0".equals(directory_id) == false) {
            return new Result(ResultCode.FILE_OR_DIRECTORY_NOT_FOUND.code, ResultCode.FILE_OR_DIRECTORY_NOT_FOUND.msg);
        } else if (directory != null && user_id.equals(directory.getUser_id()) == false) {
            return new Result(ResultCode.USER_ID_NOT_THE_SAME.code, ResultCode.USER_ID_NOT_THE_SAME.msg);
        } else if (directory != null && directory.getDirectoryIsFile().equals(0) == false) {
            return new Result(ResultCode.DIRECTORY_IS_FILE.code, ResultCode.DIRECTORY_IS_FILE.msg);
        } else {
            return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, directoryService.selectDirectories(directory_id, user_id.toString()));
        }

    }

    @GetMapping("/getDirInfoById/{directory_id}")
    public Result getDirInfoById(@RequestAttribute("user_id") Integer user_id,
                                 @PathVariable("directory_id") String directory_id) {
        Directory directory = directoryService.getById(directory_id);

        Map<String, Object> map = new HashMap<>();

        if (directory == null || directory.getUser_id().equals(user_id) == false) {
            return new Result(ResultCode.USER_ID_MISMATCH.code, ResultCode.USER_ID_MISMATCH.msg);
        } else if (directory.getDirectoryIsFile().equals(0)) {
            map.put("Directory", directory);
            return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, map);
        } else {
            File file = fileService.getById(directory.getDirectoryIsFile());

            map.put("Directory", directory);
            map.put("File", file);

            return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, map);
        }

    }

}

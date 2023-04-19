package com.dream.adminservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dream.adminservice.common.Result;
import com.dream.adminservice.common.ResultCode;
import com.dream.adminservice.mapper.UserMapper;
import com.dream.adminservice.pojo.User;
import com.dream.adminservice.service.UserService;
import com.dream.adminservice.utils.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    /**
     * 根据userId删除用户
     *
     * @param userId
     * @return
     */
    @DeleteMapping("/delete/{userId}")
    public Result delete(@PathVariable Long userId) {
        userService.removeById(userId);
        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg);
    }

    /**
     * 添加user
     *
     * @param user
     * @return
     */
    @PostMapping("/add")
    public Result<Map> add(@RequestBody User user) {
        user.setUserPassword(Md5Util.encryptPassword(user.getUserPassword()));
        userMapper.insert(user);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("items",user);
        return new Result<Map>(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg,map);
    }

    /**
     * 根据用户Id查询
     *
     * @param userId
     * @return
     */
    @GetMapping("/getById/{userId}")
    public Result<Map> getByUserId(@PathVariable Long userId) {
        User user = userService.getById(userId);
        if(user == null)
            return new Result<Map>(ResultCode.USER_IS_NOT_EXTENT.code,ResultCode.USER_IS_NOT_EXTENT.msg,null);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("items",user);
        return new Result<Map>(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, map);
    }

    /**
     * 根据用户 userId 进行更新
     *
     * @param user
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        userService.updateById(user);
        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg);
    }

    @GetMapping("/getName/{userName}")
    public Result<Map> getByUserName(@PathVariable String userName, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("user_name", userName);
        Page<User> page1 = new Page<>(page, size);
        Page<User> userPage = userMapper.selectPage(page1, qw);
        List<User> users = userPage.getRecords();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("total",users.size());
        map.put("items",users);
        return new Result<Map>(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, map);
    }

    @GetMapping("/list")
    public Result<Map> list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {

        List<User> users = userService.listByCondition(page, size);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("total",users.size());
        map.put("items",users);
        return new Result<Map>(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, map);
    }
}

package com.dream.adminservice.controller;

import com.alibaba.fastjson.JSON;
import com.dream.adminservice.common.Result;
import com.dream.adminservice.common.ResultCode;
import com.dream.adminservice.pojo.Admin;
import com.dream.adminservice.service.AdminService;
import com.dream.adminservice.utils.JwtUtils;
import com.dream.adminservice.utils.Md5Util;
import com.dream.adminservice.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class AdminController {


    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private AdminService adminService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody Map map) {
        String password = map.get("admin_password").toString();
        String admin_name_or_email = map.get("admin_name_or_email").toString();
        Admin admin = null;
        if (admin_name_or_email.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$") == true) {
            admin = adminService.findByEmail(admin_name_or_email);
        } else {
            admin = adminService.findByName(admin_name_or_email);
        }

        if (admin == null) {
            return new Result<String>(ResultCode.ADMIN_EMAIL_NAME_MISMATCH.code, ResultCode.ADMIN_EMAIL_NAME_MISMATCH.msg);
        }
        if (!Md5Util.matches(password,admin.getAdminPassword())) {
            return new Result<String>(ResultCode.ADMIN_PASSWORD_MISMATCH.code, ResultCode.ADMIN_PASSWORD_MISMATCH.msg);
        }
//        if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(admin.getAdminPassword())) {
//            return new Result<String>(ResultCode.ADMIN_PASSWORD_MISMATCH.code, ResultCode.ADMIN_PASSWORD_MISMATCH.msg);
//        }
        Map tokenMap = new HashMap();
        tokenMap.put("adminId", admin.getAdminId());
        tokenMap.put("adminAuthority", admin.getAdminAuthority());
        String token = JwtUtils.getToken(tokenMap);
        System.out.println(token);
        Result<String> stringResult = new Result<String>(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, token);
        //System.out.println(stringResult);
        return stringResult;
    }

    @PostMapping("/showTotal")
    public Result<Map<String, Object>> showTotal()
    {
        Object totalDisplay = redisUtil.get("Total_display") == null ? 0 :redisUtil.get("Total_display");
        Object totalSegment = redisUtil.get("Total_segment") == null ? 0 :redisUtil.get("Total_segment");
        Object totalAnalyse = redisUtil.get("Total_analyse") == null ? 0 :redisUtil.get("Total_analyse");
        Object totalContrast = redisUtil.get("Total_contrast") == null ? 0 :redisUtil.get("Total_contrast");
        Map<String, Object> map = new HashMap<>();
        map.put("totalDisplay",totalDisplay);
        map.put("totalSegment",totalSegment);
        map.put("totalAnalyse",totalAnalyse);
        map.put("totalContrast",totalContrast);
        return new Result<>(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg,map);
    }


    @GetMapping("/checkLogin")
    public Result<String> check(@RequestHeader("Authorization") String token) {
        //判断token是否合法
        boolean verifyToken = JwtUtils.verifyToken(token);
        if (!verifyToken) {
            return new Result<String>(ResultCode.ADMIN_TOKEN_ILLEGAL.code, ResultCode.ADMIN_TOKEN_ILLEGAL.msg);
        }
        return new Result<String>(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg);
    }


}

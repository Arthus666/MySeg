package com.dream.userservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.dream.userservice.entity.*;
import com.dream.userservice.enumeration.ResultCode;
import com.dream.userservice.service.IHistoryService;
import com.dream.userservice.service.IUserService;
import com.dream.userservice.utils.EmailUtil;
import com.dream.userservice.utils.JwtUtil;
import com.dream.userservice.utils.Md5Util;
import com.dream.userservice.utils.RedisUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Arthus
 * @since 2023-03-08
 */
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private IUserService userService;

    @Autowired
    private IHistoryService historyService;

    @GetMapping("/checkLogin")
    public Result checkLogin(@RequestHeader("user_token") String user_token) {

        if (user_token == null) {
            return new Result(ResultCode.USER_TOKEN_ISNULL.code, ResultCode.USER_TOKEN_ISNULL.msg);
        }

        Integer user_id = JwtUtil.getClaim(user_token);

        if (user_id == null) {
            return new Result(ResultCode.USER_TOKEN_MISMATCH.code, ResultCode.USER_TOKEN_MISMATCH.msg);
        } else {
            User user = userService.getById(user_id);
            return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, user);
        }
    }

    @GetMapping("/get_vertifycode/{user_email}")
    public Result getVertifyCode(@PathVariable String user_email) {

        if (user_email == null) {

            //邮箱不能为空
            return new Result(ResultCode.EMAIL_ISNULL.code, ResultCode.EMAIL_ISNULL.msg);

        } else if (user_email.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$") == false) {

            //邮箱格式错误
            return new Result(ResultCode.EMAIL_FORMAT_MISMATCH.code, ResultCode.EMAIL_FORMAT_MISMATCH.msg);

        } else {

            //随机生成六位数字验证码
            int vertiyCode = (int) ((Math.random() * 9 + 1) * 100000);

            //发送验证码
            EmailUtil.sendEmail(user_email, vertiyCode);

            //将验证码存到redis里面
            redisUtil.set("vertiyCode:" + user_email, vertiyCode);

            //设置过期时间为五分钟
            redisUtil.expire("vertiyCode:" + user_email, 300);

            //邮箱验证码发送成功
            return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg);
        }

    }

    @PostMapping("/register")
    public Result userRegister(@RequestBody String jsonStr) {

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        String user_name = jsonObject.getString("user_name");
        String user_email = jsonObject.getString("user_email");
        String user_password = jsonObject.getString("user_password");
        String user_confirm = jsonObject.getString("user_confirm");
        String user_vertifyCode = jsonObject.getString("user_vertifyCode");

        if (user_name == null || user_password == null || user_confirm == null || user_email == null || user_vertifyCode == null) {

            return new Result(ResultCode.INPUT_ISNULL.code, ResultCode.INPUT_ISNULL.msg);

        } else if (user_name.matches("^[a-zA-Z0-9_]{3,16}$") == false) {

            return new Result(ResultCode.USERNAME_FORMAT_MISMACTH.code, ResultCode.USERNAME_FORMAT_MISMACTH.msg);

        } else if (user_password.matches("^[a-zA-Z0-9_]{6,16}$") == false) {

            return new Result(ResultCode.USER_PASSWORD_FORMAT_MISMATCH.code, ResultCode.USER_PASSWORD_FORMAT_MISMATCH.msg);

        } else if (user_password.equals(user_confirm) == false) {

            return new Result(ResultCode.USER_CONFIRM_MISMATCH.code, ResultCode.USER_CONFIRM_MISMATCH.msg);

        } else if (user_email.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$") == false) {

            return new Result((ResultCode.EMAIL_FORMAT_MISMATCH.code), ResultCode.EMAIL_FORMAT_MISMATCH.msg);

        } else if (user_vertifyCode == null || redisUtil.get("vertiyCode:" + user_email) == null || user_vertifyCode.equals(redisUtil.get("vertiyCode:" + user_email).toString()) == false) {

            return new Result(ResultCode.VERTIFYCODE_MISMATCH.code, ResultCode.VERTIFYCODE_MISMATCH.msg);

        } else if (userService.selectUserByUsername(user_name) != null) {

            return new Result(ResultCode.USER_NAME_DUPLICATE.code, ResultCode.USER_NAME_DUPLICATE.msg);

        } else if (userService.selectUserByEmail(user_email) != null) {

            return new Result(ResultCode.USER_EMAIL_DUPLICATE.code, ResultCode.USER_EMAIL_DUPLICATE.msg);

        } else {

            //保存用户
            userService.save(new User(0, user_name, user_email, Md5Util.encryptPassword(user_password)));

            return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg);

        }
    }

    @PostMapping("/login")
    public Result userLogin(@RequestBody String jsonStr) {

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        String user_name_or_email = jsonObject.getString("user_name_or_email");
        String user_password = jsonObject.getString("user_password");

        if ("".equals(user_name_or_email) || "".equals(user_password)) {

            return new Result(ResultCode.INPUT_ISNULL.code, ResultCode.INPUT_ISNULL.msg);

        } else if (user_name_or_email.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$") == true) {

            //邮箱登录
            User user = userService.selectUserByEmail(user_name_or_email);

            if (user == null || Md5Util.matches(user_password, user.getUserPassword()) == false) {

                return new Result(ResultCode.USER_EMAIL_OR_PASSWORD_MISMATCH.code, ResultCode.USER_EMAIL_OR_PASSWORD_MISMATCH.msg);

            } else {

                //获取数据展示次数
                if (redisUtil.get("User_" + user.getUserId() + "_display") == null) {
                    redisUtil.set("User_" + user.getUserId() + "_display", 0, 259200);
                }
                //获取数据分割次数
                if (redisUtil.get("User_" + user.getUserId() + "_segment") == null) {
                    redisUtil.set("User_" + user.getUserId() + "_segment", 0, 259200);
                }
                //获取数据分析次数
                if (redisUtil.get("User_" + user.getUserId() + "_analyse") == null) {
                    redisUtil.set("User_" + user.getUserId() + "_analyse", 0, 259200);
                }
                //获取数据对比次数
                if (redisUtil.get("User_" + user.getUserId() + "_contrast") == null) {
                    redisUtil.set("User_" + user.getUserId() + "_contrast", 0, 259200);
                }

                String user_token = JwtUtil.generateToken(user.getUserId());

                return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, new UserToken(user_token));

            }
        } else {

            //用户名登录
            User user = userService.selectUserByUsername(user_name_or_email);

            if (user == null || Md5Util.matches(user_password, user.getUserPassword()) == false) {

                return new Result(ResultCode.USER_NAME_OR_PASSWORD_MISMATCH.code, ResultCode.USER_NAME_OR_PASSWORD_MISMATCH.msg);

            } else {

                //获取数据展示次数
                if (redisUtil.get("User_" + user.getUserId() + "_display") == null) {
                    redisUtil.set("User_" + user.getUserId() + "_display", 0, 259200);
                }
                //获取数据分割次数
                if (redisUtil.get("User_" + user.getUserId() + "_segment") == null) {
                    redisUtil.set("User_" + user.getUserId() + "_segment", 0, 259200);
                }
                //获取数据分析次数
                if (redisUtil.get("User_" + user.getUserId() + "_analyse") == null) {
                    redisUtil.set("User_" + user.getUserId() + "_analyse", 0, 259200);
                }
                //获取数据对比次数
                if (redisUtil.get("User_" + user.getUserId() + "_contrast") == null) {
                    redisUtil.set("User_" + user.getUserId() + "_contrast", 0, 259200);
                }

                String user_token = JwtUtil.generateToken(user.getUserId());

                return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, new UserToken(user_token));
            }

        }

    }

    @PostMapping("/changePassword")
    public Result changePassword(@RequestHeader("user_token") String user_token, @RequestBody String jsonStr) {

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        String new_password = jsonObject.getString("new_password");
        String confirm_password = jsonObject.getString("confirm_password");

        if (user_token == null) {

            return new Result(ResultCode.USER_TOKEN_ISNULL.code, ResultCode.USER_TOKEN_ISNULL.msg);

        } else if (new_password == null || confirm_password == null) {

            return new Result(ResultCode.INPUT_ISNULL);

        } else if (new_password.equals(confirm_password) == false) {

            return new Result(ResultCode.USER_CONFIRM_MISMATCH.code, ResultCode.USER_CONFIRM_MISMATCH.msg);

        } else if (new_password.matches("^[a-zA-Z0-9_]{6,16}$") == false) {

            return new Result(ResultCode.USER_PASSWORD_FORMAT_MISMATCH.code, ResultCode.USER_PASSWORD_FORMAT_MISMATCH.msg);

        }

        Integer user_id = JwtUtil.getClaim(user_token);

        if (user_id == null) {
            return new Result(ResultCode.USER_TOKEN_MISMATCH.code, ResultCode.USER_TOKEN_MISMATCH.msg);
        } else {

            userService.updateUserPassword(user_id, Md5Util.encryptPassword(new_password));
            return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg);
        }

    }

    @PutMapping("/changeEmail/{new_email}/{vertifyCode}")
    public Result changePassword(@RequestHeader("user_token") String user_token,
                                 @PathVariable("new_email") String new_email,
                                 @PathVariable("vertifyCode") String vertifyCode) {

        if (user_token == null) {

            return new Result(ResultCode.USER_TOKEN_ISNULL.code, ResultCode.USER_TOKEN_ISNULL.msg);

        } else if (new_email.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$") == false) {

            return new Result((ResultCode.EMAIL_FORMAT_MISMATCH.code), ResultCode.EMAIL_FORMAT_MISMATCH.msg);

        } else if (vertifyCode == null || redisUtil.get("vertiyCode:" + new_email) == null || vertifyCode.equals(redisUtil.get("vertiyCode:" + new_email).toString()) == false) {

            return new Result(ResultCode.VERTIFYCODE_MISMATCH.code, ResultCode.VERTIFYCODE_MISMATCH.msg);

        } else if (userService.selectUserByEmail(new_email) != null) {

            return new Result(ResultCode.USER_EMAIL_DUPLICATE.code, ResultCode.USER_EMAIL_DUPLICATE.msg);

        }

        Integer user_id = JwtUtil.getClaim(user_token);

        if (user_id == null) {
            return new Result(ResultCode.USER_TOKEN_MISMATCH.code, ResultCode.USER_TOKEN_MISMATCH.msg);
        } else {
            userService.updateUserEmail(user_id, new_email);
            return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg);
        }

    }

    @PutMapping("/usageCount/{user_id}/{latest_function}/{latest_file_id}")
    public Result usageCount(@PathVariable("user_id") Integer user_id,
                             @PathVariable("latest_function") String latest_function,
                             @PathVariable("latest_file_id") String latest_file_id) {

        if (user_id == null || latest_function == null || latest_file_id == null) {
            return new Result(ResultCode.INPUT_ISNULL.code, ResultCode.INPUT_ISNULL.msg);
        }

        if (latest_function.equals("display") == false && latest_function.equals("segment") == false && latest_function.equals("analyse") == false && latest_function.equals("contrast") == false) {
            return new Result<>(ResultCode.FUNCTION_NOT_EXIST.code, ResultCode.FUNCTION_NOT_EXIST.msg);
        }

        redisUtil.incr("User_" + user_id + "_" + latest_function, 1);

        redisUtil.set("User_" + user_id + "_latest_function", latest_function, 259200);

        redisUtil.set("User_" + user_id + "_latest_file_id", latest_file_id, 259200);

        if (redisUtil.get("Total_" + latest_function) == null) {
            redisUtil.set("Total_" + latest_function, 1);
        } else {
            redisUtil.incr("Total_" + latest_function, 1);
        }

        //格式化当前日期和时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String file_time = dateFormat.format(new Date(System.currentTimeMillis()));

        historyService.save(new History(0, user_id, Integer.valueOf(latest_file_id), latest_function, file_time));

        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg);

    }

    @GetMapping("/getUsageCount/{user_id}")
    public Result getUsageCount(@PathVariable("user_id") Integer user_id) {

        if (user_id == null) {
            return new Result(ResultCode.INPUT_ISNULL.code, ResultCode.INPUT_ISNULL.msg);
        }

        int user_display = Integer.valueOf(redisUtil.get("User_" + user_id + "_display").toString());
        int user_segment = Integer.valueOf(redisUtil.get("User_" + user_id + "_segment").toString());
        int user_analyse = Integer.valueOf(redisUtil.get("User_" + user_id + "_analyse").toString());
        int user_contrast = Integer.valueOf(redisUtil.get("User_" + user_id + "_contrast").toString());

        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, new UsageCount(user_display, user_segment, user_analyse, user_contrast));
    }

    @GetMapping("/getUserHistory/{user_id}")
    public Result getUserHistory(@PathVariable("user_id") Integer user_id) {
        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, historyService.selectHistory(user_id));
    }

    @GetMapping("/getTotalCount")
    public Result getTotalCount() {

        Integer Total_display = redisUtil.get("Total_display") == null ? 0 : Integer.valueOf(redisUtil.get("Total_display").toString());
        Integer Total_segment = redisUtil.get("Total_segment")== null ? 0 : Integer.valueOf(redisUtil.get("Total_segment").toString());
        Integer Total_analyse = redisUtil.get("Total_analyse")== null ? 0 : Integer.valueOf(redisUtil.get("Total_analyse").toString());
        Integer Total_contrast =redisUtil.get("Total_contrast")== null ? 0 : Integer.valueOf(redisUtil.get("Total_contrast").toString());

        return new Result(ResultCode.SUCCESS.code, ResultCode.SUCCESS.msg, new UsageCount(Total_display, Total_segment, Total_analyse, Total_contrast));
    }

}

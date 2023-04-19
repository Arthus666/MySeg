package com.dream.userservice.utils;

import com.dream.userservice.controller.UserController;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Arthus
 */
public class EmailUtil {

    private static final Logger logger = LoggerFactory.getLogger(EmailUtil.class);

    /**
     * 发送邮箱验证码
     * @param emailaddress
     * @param code
     * @return
     */
    public static boolean sendEmail(String emailaddress, int code) {
        try {
            //不用更改
            HtmlEmail email = new HtmlEmail();
            //需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
            email.setHostName("smtp.qq.com");
            email.setCharset("UTF-8");
            // 收件地址
            email.addTo(emailaddress);

            //此处填邮箱地址和用户名,用户名可以任意填写
            email.setFrom("1305663753@qq.com", "Intelligent Medical System");

            //此处填写邮箱地址和客户端授权码
            email.setAuthentication("1305663753@qq.com", "thsogqapjisciddi");

            //此处填写邮件名，邮件名可任意填写
            email.setSubject("基于百度飞桨的智疗系统");

            //此处填写邮件内容
            email.setMsg("尊敬的用户您好,您本次注册的验证码是:" + '\n' + code+"\n"+"有效时长为 五分钟");

            email.send();

            logger.info("获取邮箱：{}，发送验证码：{}", emailaddress, code);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}

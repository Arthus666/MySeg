package com.dream.userservice.utils;

import org.springframework.util.DigestUtils;

/**
 * @author Arthus
 */
public class Md5Util {

    /**
     * SALT（盐）
     */
    private static final String SALT = "Whoareyou?";

    /**
     * 使用MD5加盐加密随机数生成密文
     * @return
     */
    public static String encryptRandomNumber() {
        return DigestUtils.md5DigestAsHex((Math.random()+SALT).getBytes());
    }

    /**
     * 使用MD5加盐加密密码
     * @param password
     * @return
     */
    public static String encryptPassword(String password) {
        return DigestUtils.md5DigestAsHex((password + SALT).getBytes());
    }

    /**
     * 比较原密码和MD5密文
     * @param password
     * @param encoder
     * @return
     */
    public static boolean matches(String password, String encoder) {
        return encryptPassword(password).equals(encoder);
    }

}

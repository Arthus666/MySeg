package com.dream.userservice.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Arthus
 */
public class JwtUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    /**
     * 设置过期时间 1 小时
     */
    private static final long EXPIRE_DATE = 60 * 60 * 1000;

    /**
     * token秘钥
     */
    private static final String TOKEN_SECRET = "Whoareyou?";

    /**
     * 生成token，1小时后过期
     *
     * @param userId
     * @return
     */
    public static String generateToken(int userId) {

        String token = "";
        try {

            //过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_DATE);

            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

            //设置头部信息
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");
            header.put("alg", "HS256");

            //携带用户ID唯一标识信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("userId", userId)
                    .withExpiresAt(date)
                    .sign(algorithm);

        } catch (Exception e) {
            logger.info("---Token生成失败---");
            return null;
        }
        return token;
    }

    /**
     * 验证token
     *
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        try {

            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

            JWTVerifier verifier = JWT.require(algorithm).build();

            DecodedJWT jwt = verifier.verify(token);

            return true;

        } catch (Exception e) {
            logger.info("---Token验证失败---");
            return false;
        }
    }

    /**
     * 获取token负载中的信息
     *
     * @param token
     * @return
     */
    public static Integer getClaim(String token) {

        /**
         * @desc 验证token，返回负载中的claim
         * @params [token]需要校验的串
         **/
        try {

            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

            JWTVerifier verifier = JWT.require(algorithm).build();

            DecodedJWT jwt = verifier.verify(token);

            return jwt.getClaim("userId").asInt();

        } catch (Exception e) {
            logger.info("---获取Token中的负载失败---");
            return null;
        }
    }

    /**
     * 使token立即过期
     *
     * @param userId
     * @return
     */
    public static String expireToken(int userId) {

        String token = "";

        try {

            //过期时间为当前时间即立即过期
            Date date = new Date(System.currentTimeMillis());

            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

            //设置头部信息
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");
            header.put("alg", "HS256");

            //携带用户ID唯一标识信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("userId", userId)
                    .withExpiresAt(date)
                    .sign(algorithm);

        } catch (Exception e) {
            logger.info("---使token过期失败---");
            return null;
        }
        return token;
    }

}

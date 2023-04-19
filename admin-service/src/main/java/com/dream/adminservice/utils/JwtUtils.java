package com.dream.adminservice.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static final int TOKEN_TIME_OUT = 3600;
    private static final String TOKEN_SECRET = "segmentation";

    public JwtUtils() {
    }

    public static String getToken(Map params) {
        long currentTime = System.currentTimeMillis();
        return Jwts.builder().signWith(SignatureAlgorithm.HS512, "segmentation").setExpiration(new Date(currentTime + 3600000L)).addClaims(params).compact();
    }

    public static Claims getClaims(String token) {
        return (Claims) Jwts.parser().setSigningKey("segmentation").parseClaimsJws(token).getBody();
    }

    public static boolean verifyToken(String token) {
        if (StringUtils.isEmpty(token)) {
            return false;
        } else {
            try {
                Claims var1 = (Claims) Jwts.parser().setSigningKey("segmentation").parseClaimsJws(token).getBody();
                return true;
            } catch (Exception var2) {
                return false;
            }
        }
    }
}

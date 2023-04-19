package com.dream.adminservice.interceptor;

import com.dream.adminservice.pojo.Admin;
import com.dream.adminservice.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");

        boolean verifyToken = JwtUtils.verifyToken(token);

        if (!verifyToken) {
            response.setStatus(401);
            return false;
        }

        return true;
    }


}

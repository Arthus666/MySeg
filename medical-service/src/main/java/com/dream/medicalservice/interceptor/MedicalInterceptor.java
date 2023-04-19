package com.dream.medicalservice.interceptor;

import com.dream.medicalservice.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.reflect.Method;
/**
 * @author Arthus
 */
@Component
public class MedicalInterceptor implements HandlerInterceptor {
 
    private static final Logger logger = LoggerFactory.getLogger(MedicalInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
 
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String methodName = method.getName();

        logger.info("====拦截到了方法：{}，在该方法执行之前执行====", methodName);

        String user_token = request.getHeader("user_token");

        if (user_token == null) {
            logger.info("===token为空，拦截该请求===");
            return false;
        }

        Integer user_id = JwtUtil.getClaim(user_token);

        if (user_id==null) {
            logger.info("===token验证未通过，拦截该请求===");
            return false;
        } else {
            request.setAttribute("user_id",user_id);
            logger.info("===token验证通过，放行该请求===");
            return true;
        }

    }

}

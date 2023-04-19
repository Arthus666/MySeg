package com.dream.adminservice.config;

import com.dream.adminservice.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor())
                .addPathPatterns("/admin/**", "/user/**", "/introduction/**", "/file/**")
                .excludePathPatterns("/admin/login", "/admin/checkLogin", "/admin/hello");
        super.addInterceptors(registry);
    }

}
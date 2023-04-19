package com.dream.medicalservice.config;

import com.dream.medicalservice.interceptor.MedicalInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private MedicalInterceptor medicalInterceptor;

    /**
     * 配置请求拦截器
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(medicalInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}

package com.dream.segservice.config;

import com.dream.segservice.interceptor.SegInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private SegInterceptor segInterceptor;

    /**
     * 配置请求拦截器
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(segInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}

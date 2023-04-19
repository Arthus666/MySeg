package com.dream.segservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.dream.segservice.mapper")
public class SegServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SegServiceApplication.class, args);
    }

}

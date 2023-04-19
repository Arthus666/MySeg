package com.dream.userservice;

import com.dream.userservice.service.IUserService;
import com.dream.userservice.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class UserServiceApplicationTests {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IUserService userService;

    @Test
    void contextLoads() {

    }

    @Test
    void TestRedis() {
        System.out.println(redisUtil.get("User_id"));
    }

    @Test
    void TestSys() {

    }

}

package com.dream.adminservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class AdminServiceApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    void testMd() throws InterruptedException {
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
        Thread.sleep(100000);
    }

}

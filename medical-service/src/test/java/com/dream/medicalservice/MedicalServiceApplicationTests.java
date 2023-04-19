package com.dream.medicalservice;

import com.dream.medicalservice.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.UUID;

@SpringBootTest
class MedicalServiceApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(MedicalServiceApplicationTests.class);

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
    }

    @Test
    void TestString() {
        String source_path = "D:\\MedicalService\\UserFiles\\User_3\\segmented\\9f87352e-50a9-4bcc-ae6f-dd5b45524a90.jpg";
        String[] nodes = source_path.split("\\\\");
        for (String node : nodes) {
            System.out.println(node);
        }
        String source_name = nodes[nodes.length-1];
        System.out.println(source_name);
    }

    @Test
    void TestCopy() {

    }

    public void copyFileUsingNIO(String source_path, String dest_path) {
        try (FileChannel in = new FileInputStream(source_path).getChannel(); FileChannel out = new FileOutputStream(dest_path).getChannel()) {
            out.transferFrom(in, 0, in.size());
            logger.info("文件复制完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFileUsingIO(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            logger.info("文件复制完成");
        } finally {
            is.close();
            os.close();
        }
    }

}

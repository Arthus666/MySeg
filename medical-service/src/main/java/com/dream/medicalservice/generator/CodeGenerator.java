package com.dream.medicalservice.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

/**
 * @author Arthus
 */
public class CodeGenerator {

    public static void main(String[] args) {
        generate();
    }

    /**
     * 新版本代码生成器，仅适用Mybatis-Plus 3.5.1版本及以上
     */
    private static void generate() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/segmentation?serverTimezone=GMT%2b8", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("Arthus") // 设置作者
                            .outputDir("D:\\Java\\MySeg\\medical-service\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.dream.medicalservice") // 设置父包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\Java\\MySeg\\medical-service\\src\\main\\resources\\mapper\\")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok();
                    builder.mapperBuilder().enableMapperAnnotation().build();
                    builder.controllerBuilder().enableHyphenStyle()  // 开启驼峰转连字符
                            .enableRestStyle();  // 开启生成@RestController 控制器
                    builder.addInclude("history"); // 设置需要生成的表名
                })
                .execute();

    }
}

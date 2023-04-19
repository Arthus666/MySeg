package com.dream.adminservice.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 用户
 */
@Data
public class User {

    // 用户Id
    @TableId(type = IdType.AUTO)
    private Long userId;
    // 用户名字
    private String userName;
    // 用户邮箱
    private String userEmail;

    private String userPassword;
//     用户最新文件
//    private Integer userLatestFile;
//    // 用户最新使用
//    private Integer userLatestUse;
//    // 用户最新展示
//    private Integer userUseDisplay;
//    // 用户最新切片
//    private Integer userUseSegment;
//    //  用户最新分析
//    private Integer userUseAnalyze;

}

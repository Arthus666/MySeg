package com.dream.adminservice.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 管理者
 */
@Data
public class Admin {

    //管理员id
    @TableId(type = IdType.AUTO)
    private Long adminId;

    //管理员姓名
    private String adminName;

    //管理员邮箱
    private String adminEmail;

    //管理员密码
    private String adminPassword;

    private String adminAuthority;
}

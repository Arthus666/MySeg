package com.dream.adminservice.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Introduction {
    @TableId(type = IdType.AUTO)
    private Long introId;

    private String introTitle;

    private String introContent;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String introTime;

    private String introOrganPath;

    private String introWholePath;
}

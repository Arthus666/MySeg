package com.dream.adminservice.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 文件
 */
@Data
public class File {
    // 文件Id
    @TableId(type = IdType.AUTO)
    private Long fileId;
    // 文件用户Id
    private Long userId;
    // 文件名
    private String fileName;
    // 文件状态
    private Integer fileStatus;
    // 文件大小
    private String fileSize;

    // 文件模型
    private String fileModel;
    // 文件类型
    private String fileType;
    // 文件创建时间
//    @TableField(fill = FieldFill.INSERT)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String fileTime;
    // 文件路径
    private String filePath;
    // 文件标签
    private String fileLink;

    public File(Long fileId, Long userId, String fileName, Integer fileStatus, String fileSize, String fileType, String fileTime, String filePath, String fileLink) {
        this.fileId = fileId;
        this.userId = userId;
        this.fileName = fileName;
        this.fileStatus = fileStatus;
        this.fileSize = fileSize;
        this.fileType = fileType;
        this.fileTime = fileTime;
        this.filePath = filePath;
        this.fileLink = fileLink;
    }

    public File(Long fileId, Long userId, String fileName, Integer fileStatus, String fileSize, String fileModel, String fileType, String fileTime, String filePath, String fileLink) {
        this.fileId = fileId;
        this.userId = userId;
        this.fileName = fileName;
        this.fileStatus = fileStatus;
        this.fileSize = fileSize;
        this.fileModel = fileModel;
        this.fileType = fileType;
        this.fileTime = fileTime;
        this.filePath = filePath;
        this.fileLink = fileLink;
    }

    public File(){}

    public File(long l, Long userId, String fileOriginalName, int i, String fileSize, String fileSuffix, String toString, String filePath, String fileLink) {
        fileId = l;
        this.userId = userId;
        fileName = fileOriginalName;
        this.fileSize = fileSize;
        this.fileTime = toString;
        this.fileLink = fileLink;
        this.filePath = filePath;
        this.fileStatus = i;
        fileType = fileSuffix;

    }
}

package com.dream.adminservice.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 目录
 */
@Data
public class Directory {
    // 目录Id
    @TableId(type = IdType.AUTO)
    private Long directoryId;
    // 用户userId
    private Long userId;

    private String directoryName;

    // 目录父母Id
    private Long directoryParentId;
    // 目录是否为文件
    private Long directoryIsFile;

    private String fileLink;

    public Directory(long l, Long userId, String fileOriginalName, long l1, Long fileId, String fileLink) {
        directoryId = l;
        this.userId = userId;
        directoryName = fileOriginalName;
        directoryParentId = l1;
        directoryIsFile = fileId;
        this.fileLink = fileLink;
    }
}

package com.dream.medicalservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Arthus
 * @since 2023-03-10
 */
@Getter
@Setter
@AllArgsConstructor
public class File implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "file_id", type = IdType.AUTO)
    private Integer fileId;

    private Integer userId;

    private String fileName;

    private Byte fileStatus;

    private String fileSize;

    private String fileType;

    private String fileModel;

    private String fileTime;

    private String filePath;

    private String fileLink;
}

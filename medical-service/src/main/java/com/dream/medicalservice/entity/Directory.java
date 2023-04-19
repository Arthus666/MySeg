package com.dream.medicalservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Arthus
 * @since 2023-03-11
 */
@Getter
@Setter
@AllArgsConstructor
public class Directory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "directory_id", type = IdType.AUTO)
    private Integer directoryId;

    private Integer user_id;

    private String directoryName;

    private Integer directoryParentId;

    private Integer directoryIsFile;

    private String fileLink;

    private Byte fileStatus;

    private String fileModel;

    private String fileTime;

}

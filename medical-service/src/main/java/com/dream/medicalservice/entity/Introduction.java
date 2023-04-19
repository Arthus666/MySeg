package com.dream.medicalservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author Arthus
 * @since 2023-04-02
 */
@Getter
@Setter
public class Introduction implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "intro_id", type = IdType.AUTO)
    private Integer introId;

    private String introTitle;

    private String introContent;

    private String introTime;

    private String introOrganPath;

    private String introWholePath;
}

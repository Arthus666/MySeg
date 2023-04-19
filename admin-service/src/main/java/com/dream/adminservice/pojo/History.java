package com.dream.adminservice.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Arthus
 * @since 2023-04-09
 */
@Getter
@Setter
@AllArgsConstructor
public class History implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "his_id", type = IdType.AUTO)
    private Integer hisId;

    private Integer userId;

    private Integer fileId;

    private String hisFunction;

    private String hisTime;
}

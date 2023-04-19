package com.dream.userservice.service;

import com.dream.userservice.entity.History;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Arthus
 * @since 2023-04-09
 */
public interface IHistoryService extends IService<History> {

    List<History> selectHistory(Integer user_id);

}

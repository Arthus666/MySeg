package com.dream.userservice.mapper;

import com.dream.userservice.entity.History;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Arthus
 * @since 2023-04-09
 */
@Mapper
public interface HistoryMapper extends BaseMapper<History> {

    @Select("select * from history where user_id=#{user_id} order by his_id desc")
    List<History> selectHistory(@Param("user_id") Integer user_id);

}

package com.dream.userservice.mapper;

import com.dream.userservice.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Arthus
 * @since 2023-03-08
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Update("update user set user_password=#{new_password} where user_id=#{user_id}")
    void updateUserPassword(@Param("user_id") int user_id, @Param("new_password") String new_password);

    @Update("update user set user_email=#{new_email} where user_id=#{user_id}")
    void updateUserEmail(@Param("user_id") int user_id, @Param("new_email") String new_email);

}

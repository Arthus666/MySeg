package com.dream.adminservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dream.adminservice.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}

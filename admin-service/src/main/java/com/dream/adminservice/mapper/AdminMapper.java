package com.dream.adminservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dream.adminservice.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
}

package com.dream.adminservice.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dream.adminservice.pojo.File;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FileMapper extends BaseMapper<File> {


    @Select("select * from file where file_link=#{file_link}")
    File selectFileByFileLink(@Param("file_link") String file_link);

//    File selectOne(QueryWrapper<File> qw);
}

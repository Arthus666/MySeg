package com.dream.medicalservice.mapper;

import com.dream.medicalservice.entity.File;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Arthus
 * @since 2023-03-10
 */
@Mapper
public interface FileMapper extends BaseMapper<File> {

    @Select("select * from file where file_link=#{file_link}")
    File selectFileByFileLink(@Param("file_link") String file_link);

    @Select("select * from file where user_id=#{user_id} order by file_id desc")
    List<File> selectFileRecord(@Param("user_id") Integer user_id);

}

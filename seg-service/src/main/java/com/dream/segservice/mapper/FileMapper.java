package com.dream.segservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dream.segservice.entity.File;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Arthus
 * @since 2023-03-30
 */
@Mapper
public interface FileMapper extends BaseMapper<File> {
    @Select("select * from file where file_link=#{file_link}")
    File selectFileByFileLink(@Param("file_link") String file_link);
}

package com.dream.medicalservice.mapper;

import com.dream.medicalservice.entity.Directory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import javax.annotation.security.PermitAll;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Arthus
 * @since 2023-03-11
 */
@Mapper
public interface DirectoryMapper extends BaseMapper<Directory> {

    @Delete("delete from directory where directory_is_file=#{file_id}")
    void removeFileDirctory(Integer file_id);

    @Update("update directory set directory_parent_id=#{new_parent_id} where directory_is_file=#{file_id}")
    void moveFileDirectory(@Param("new_parent_id") String new_parent_id, @Param("file_id") String file_id);

    @Update("update directory set directory_name=#{directory_name} where directory_id=#{directory_id}")
    void updateDirectoryName(@Param("directory_name") String directory_name, @Param("directory_id") String directory_id);

    @Select("select * from directory where directory_parent_id=#{directory_id} and user_id=#{user_id} and directory_is_file=0")
    List<Directory> selectDirectories(@Param("directory_id") String directory_id, @Param("user_id") String user_id);

}

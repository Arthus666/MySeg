package com.dream.medicalservice.service;

import com.dream.medicalservice.entity.Directory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Arthus
 * @since 2023-03-11
 */
public interface IDirectoryService extends IService<Directory> {

    void removeFileDirctory(Integer file_id);

    void moveFileDirectory(String new_parent_id, String file_id);

    void updateDirectoryName(String directory_name, String directory_id);

    List<Directory> selectDirectoriesAndFiles(String directory_id, String user_id);

    List<Directory> selectDirectories(String directory_id, String user_id);

}

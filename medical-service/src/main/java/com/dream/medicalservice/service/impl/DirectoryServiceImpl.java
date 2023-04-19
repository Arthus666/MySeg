package com.dream.medicalservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dream.medicalservice.entity.Directory;
import com.dream.medicalservice.mapper.DirectoryMapper;
import com.dream.medicalservice.service.IDirectoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Arthus
 * @since 2023-03-11
 */
@Service
public class DirectoryServiceImpl extends ServiceImpl<DirectoryMapper, Directory> implements IDirectoryService {

    @Autowired
    private DirectoryMapper directoryMapper;

    @Override
    public void removeFileDirctory(Integer file_id) {
        directoryMapper.removeFileDirctory(file_id);
    }

    @Override
    public void moveFileDirectory(String new_parent_id, String file_id) {
        directoryMapper.moveFileDirectory(new_parent_id, file_id);
        return;
    }

    @Override
    public void updateDirectoryName(String directory_name, String directory_id) {
        directoryMapper.updateDirectoryName(directory_name, directory_id);
        return;
    }

    @Override
    public List<Directory> selectDirectoriesAndFiles(String directory_id, String user_id) {
        QueryWrapper<Directory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("directory_parent_id", directory_id);
        queryWrapper.eq("user_id", user_id);
        return directoryMapper.selectList(queryWrapper);
    }

    @Override
    public List<Directory> selectDirectories(String directory_id, String user_id) {
        return directoryMapper.selectDirectories(directory_id, user_id);
    }

}

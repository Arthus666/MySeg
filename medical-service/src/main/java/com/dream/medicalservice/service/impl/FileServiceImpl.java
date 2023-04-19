package com.dream.medicalservice.service.impl;

import com.dream.medicalservice.entity.File;
import com.dream.medicalservice.mapper.FileMapper;
import com.dream.medicalservice.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Arthus
 * @since 2023-03-10
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public File getFileByFileLink(String file_link) {
        return fileMapper.selectFileByFileLink(file_link);
    }

    @Override
    public List<File> getFileRecord(Integer user_id) {
        return fileMapper.selectFileRecord(user_id);
    }

}

package com.dream.adminservice.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dream.adminservice.mapper.FileMapper;
import com.dream.adminservice.pojo.File;
import com.dream.adminservice.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {
    @Autowired
    private FileMapper fileMapper;

    @Override
    public File getFileByFileLink(String fileLink) {
        String file_link = fileLink;
        return fileMapper.selectFileByFileLink(file_link);
    }
}

package com.dream.segservice.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dream.segservice.entity.File;
import com.dream.segservice.mapper.FileMapper;
import com.dream.segservice.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Arthus
 * @since 2023-03-30
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public File getFileByFileLink(String file_link) {
        return fileMapper.selectFileByFileLink(file_link);
    }

}

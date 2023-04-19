package com.dream.adminservice.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dream.adminservice.mapper.DirectoryMapper;
import com.dream.adminservice.pojo.Directory;
import com.dream.adminservice.service.DirectoryService;
import org.springframework.stereotype.Service;

@Service
public class DirectoryServiceImpl extends ServiceImpl<DirectoryMapper, Directory> implements DirectoryService {
}

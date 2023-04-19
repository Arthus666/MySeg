package com.dream.adminservice.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dream.adminservice.mapper.HistoryMapper;
import com.dream.adminservice.pojo.History;
import com.dream.adminservice.service.HistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl  extends ServiceImpl<HistoryMapper, History> implements HistoryService {
}

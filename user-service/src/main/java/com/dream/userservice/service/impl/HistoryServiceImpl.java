package com.dream.userservice.service.impl;

import com.dream.userservice.entity.History;
import com.dream.userservice.mapper.HistoryMapper;
import com.dream.userservice.service.IHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Arthus
 * @since 2023-04-09
 */
@Service
public class HistoryServiceImpl extends ServiceImpl<HistoryMapper, History> implements IHistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public List<History> selectHistory(Integer user_id) {
        return historyMapper.selectHistory(user_id);
    }
}

package com.dream.adminservice.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dream.adminservice.mapper.UserMapper;
import com.dream.adminservice.pojo.User;
import com.dream.adminservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getOne(String userName) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("user_name", userName);
        return userMapper.selectOne(qw);
    }

    @Override
    public List<User> listByCondition(int page, int size) {
        Page<User> page1 = new Page<>(page, size);
        Page<User> userPage = userMapper.selectPage(page1, null);
        List<User> users = userPage.getRecords();
        return users;
    }
}

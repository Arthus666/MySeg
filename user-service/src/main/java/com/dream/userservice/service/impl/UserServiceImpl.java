package com.dream.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dream.userservice.entity.User;
import com.dream.userservice.mapper.UserMapper;
import com.dream.userservice.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Arthus
 * @since 2023-03-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByUsername(String user_name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", user_name);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public User selectUserByEmail(String user_email) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_email", user_email);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public void updateUserPassword(int user_id, String new_password) {
        userMapper.updateUserPassword(user_id, new_password);
        return ;
    }

    @Override
    public void updateUserEmail(int user_id, String new_email) {
        userMapper.updateUserEmail(user_id, new_email);
        return;
    }

}

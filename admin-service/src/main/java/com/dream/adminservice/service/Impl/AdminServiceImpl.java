package com.dream.adminservice.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dream.adminservice.mapper.AdminMapper;
import com.dream.adminservice.pojo.Admin;
import com.dream.adminservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findByEmail(String email) {
        QueryWrapper<Admin> qw = new QueryWrapper<>();
        qw.eq("admin_email",email);
        return adminMapper.selectOne(qw);
    }

    @Override
    public Admin findByName(String name) {
        QueryWrapper<Admin> qw = new QueryWrapper<>();
        qw.eq("admin_name",name);
        return adminMapper.selectOne(qw);
    }
}

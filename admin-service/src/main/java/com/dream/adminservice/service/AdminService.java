package com.dream.adminservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dream.adminservice.pojo.Admin;

public interface AdminService extends IService<Admin> {


    public Admin findByEmail(String email);

    public Admin findByName(String name);
}

package com.dream.adminservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dream.adminservice.pojo.User;

import java.util.List;

public interface UserService extends IService<User> {
    User getOne(String userName);

    // 分页查询
    List<User> listByCondition(int page, int size);

}

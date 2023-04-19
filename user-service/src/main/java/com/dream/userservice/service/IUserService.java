package com.dream.userservice.service;

import com.dream.userservice.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Arthus
 * @since 2023-03-08
 */
public interface IUserService extends IService<User> {

    User selectUserByUsername(String user_name);

    User selectUserByEmail(String user_email);

    void updateUserPassword(int user_id, String new_password);

    void updateUserEmail(int user_id, String new_email);

}

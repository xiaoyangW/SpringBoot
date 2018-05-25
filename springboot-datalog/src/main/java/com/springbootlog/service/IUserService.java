package com.springbootlog.service;

import com.springbootlog.UserDataLog;
import com.springbootlog.module.User;

public interface IUserService {

    Integer updateUser(User user);

    @UserDataLog()
    Integer updateUser2( Integer id, String name, String phone);
}

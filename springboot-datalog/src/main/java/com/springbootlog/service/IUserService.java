package com.springbootlog.service;

import com.springbootlog.UserDataLog;
import com.springbootlog.module.User;

public interface IUserService {

    Integer updateUser(User user);

    Integer updateUser2( Integer id, String name, String phone);
}

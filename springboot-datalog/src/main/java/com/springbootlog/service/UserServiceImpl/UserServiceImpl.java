package com.springbootlog.service.UserServiceImpl;

import com.springbootlog.Constant;
import com.springbootlog.UserDataLog;
import com.springbootlog.dao.IUserDao;
import com.springbootlog.module.User;
import com.springbootlog.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author WXY
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {

    private IUserDao userDao;

    public UserServiceImpl(IUserDao userDao) {
        this.userDao=userDao;
    }
    @UserDataLog(operation = "update",msg = "修改用户信息")
    @Override
    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }
    @UserDataLog(operation = "update",msg = "修改用户信息",constant = {
            @Constant(name = "id",value = "用户id"),
            @Constant(name = "name",value = "用户name"),
            @Constant(name = "phone",value = "用户phone")
    })
    @Override
    public Integer updateUser2(Integer id, String name, String phone) {
        return userDao.updateUser2(id, name, phone);
    }

}

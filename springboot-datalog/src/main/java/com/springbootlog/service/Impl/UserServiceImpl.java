package com.springbootlog.service.Impl;


import com.springbootlog.dao.IUserDao;
import com.springbootlog.module.User;
import com.springbootlog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author WXY
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    /*@Autowired
    public UserServiceImpl(IUserDao userDao) {
        this.userDao=userDao;
    }*/
    //@UserDataLog
    @Override
    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public Integer updateUser2(Integer id, String name, String phone) {
        Integer f = userDao.updateUser2(id, name, phone);
        return f;
    }

}

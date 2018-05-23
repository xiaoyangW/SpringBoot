package com.springbootlog;

import com.springbootlog.dao.IUserDao;
import com.springbootlog.module.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {
    @Autowired
    IUserDao userDao;
    @Test
    public void test(){
        User user = new User();
        user.setName("wxy");
        user.setPhone("11012011923");
        System.out.println(userDao.addUser(user));
    }

}

package com.springbootlog.controller;

import com.springbootlog.dao.IUserDao;
import com.springbootlog.dto.ResponseDto;
import com.springbootlog.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author WXY
 */
@RestController
@RequestMapping("/log")
public class Controller {
    private IUserDao userDao;
    @Autowired
    public Controller(IUserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/user/{id}")
    public ResponseDto getUser(@PathVariable("id")Integer id){
        ResponseDto dto = new ResponseDto();
        dto.setData(userDao.getUser(id));
        return dto;
    }

    @PostMapping("/update")
    public ResponseDto updateUser(@RequestBody User user){
        ResponseDto dto = new ResponseDto();
        dto.setCode(userDao.updateUser(user));
        return dto;
    }

    @PostMapping("/add")
    public ResponseDto addUser(@RequestBody User user){
        ResponseDto dto = new ResponseDto();
        dto.setCode(userDao.addUser(user));
        return dto;
    }
}

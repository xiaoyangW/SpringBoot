package com.springbootlog.controller;

import com.springbootlog.dto.ResponseDto;
import com.springbootlog.module.User;
import com.springbootlog.service.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author WXY
 */
@RestController
@RequestMapping("/user")
public class TwoController {
    private IUserService userService;
    @Autowired
    public TwoController(IUserService userService) {
        this.userService = userService;
    }

    private Logger logger = LogManager.getLogger(TwoController.class.getName());

    @PostMapping("/update")
    public ResponseDto updateUser(@RequestBody User user){
        ResponseDto dto = new ResponseDto();
        userService.updateUser(user);
        return dto;
    }

}

package com.springbootlog.controller;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class Controller {
    private Logger logger = LogManager.getLogger(Controller.class.getName());
    final Level X = Level.forName("X",250);
    final Logger loggers = LogManager.getLogger();
    @GetMapping("/test")
    public void log(){
        logger.info("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        logger.error("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        logger.log(X, "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

}

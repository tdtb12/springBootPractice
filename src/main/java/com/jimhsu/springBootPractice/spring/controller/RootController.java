package com.jimhsu.springBootPractice.spring.controller;

import com.jimhsu.springBootPractice.spring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/")
    public String IndexController() {
        loginService.login();
        return "index.html";
    }

}

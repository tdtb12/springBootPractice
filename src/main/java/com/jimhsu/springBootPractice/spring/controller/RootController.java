package com.jimhsu.springBootPractice.spring.controller;

import com.jimhsu.springBootPractice.spring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

    @Autowired
    private LoginService loginService;

//    @RequestMapping("/")
//    public String Index() {
//        loginService.login();
//        return "index.html";
//    }

    @GetMapping("/login")
    public String LoginPage() {
        return "login/login";
    }

    @PostMapping("/login")
    public String Login() {

        return "login/login";
    }

}

package com.jimhsu.springBootPractice.spring.service.impl;

import com.jimhsu.springBootPractice.constants.Constants;
import com.jimhsu.springBootPractice.spring.service.LoginService;
import com.jimhsu.springBootPractice.utils.LogBack;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService {

    @Override
    public String login() {

        try {
            System.out.println("Do Some DB works...");
        } catch (Exception e) {
            LogBack.LOGGER_INFO.error("",e);
        }
        // Test afterThrowing advice
//        List<String> stringList = new ArrayList<>();
//        stringList.get(2);
        return null;

    }
}

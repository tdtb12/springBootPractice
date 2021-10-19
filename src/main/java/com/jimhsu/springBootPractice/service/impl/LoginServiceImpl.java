package com.jimhsu.springBootPractice.service.impl;

import com.jimhsu.springBootPractice.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService {

    @Override
    public String login() {
        System.out.println("Executing login...");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            System.out.println(e);
        }
        // Test afterThrowing advice
        // List<String> stringList = new ArrayList<>();
        // stringList.get(2);
        return null;
    }
}

package com.jimhsu.springBootPractice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Aspect
@Component
public class LoginAspect {

    @Pointcut("execution(String com.jimhsu.springBootPractice.service.impl.LoginServiceImpl.*())")
    public void loginServicePointCut() {
        System.out.println("Aspect before login()");
    }

    @Around("loginServicePointCut()")
    public Object aroundLoginServicePointCut(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + ((end - begin) / 1000.0) + "s");

        return result;
    }

    @AfterThrowing(pointcut = "loginServicePointCut()", throwing = "exception")
    public void afterThrowingLoginServicePointCut(JoinPoint joinPoint, Throwable exception) {
        System.out.println(joinPoint.getSignature().toShortString() + " throws " + exception);
    }

}

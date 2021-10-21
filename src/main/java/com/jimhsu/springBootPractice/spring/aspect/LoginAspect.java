package com.jimhsu.springBootPractice.spring.aspect;

import com.jimhsu.springBootPractice.constants.Constants;
import com.jimhsu.springBootPractice.utils.LogBack;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoginAspect {

    // Service execution pointcut
    @Pointcut("execution(String com.jimhsu.springBootPractice.spring.service.impl.LoginServiceImpl.*())")
    public void loginServicePointCut() {
        System.out.println("Aspect before login()");
    }

    // Service啟動前後加上log並印出執行時間
    @Around("loginServicePointCut()")
    public Object aroundLoginServicePointCut(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LogBack.LOGGER_INFO.info("[{}] ---" + Constants.API_START, proceedingJoinPoint.getSignature().toShortString());

        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();
        LogBack.LOGGER_INFO.info("[{}] ---" + Constants.API_END, proceedingJoinPoint.getSignature().toShortString());
        LogBack.LOGGER_INFO.info("Execution time: {}s", (end - begin) / 100.0);
        return result;
    }

    // 處理service中沒有用try catch處理的exception
    @AfterThrowing(pointcut = "loginServicePointCut()", throwing = "exception")
    public void afterThrowingLoginServicePointCut(JoinPoint joinPoint, Throwable exception) {
        LogBack.LOGGER_INFO.error("[{}] throws exception...", joinPoint.getSignature().toShortString());
    }

}

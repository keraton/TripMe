package com.github.keraton.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

@Component
public class LoggingAdvice {


    @Around("execution(* com.github.keraton.client.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before call");
        Object proceed = joinPoint.proceed();
        System.out.println("After call");
        return proceed;
    }
}

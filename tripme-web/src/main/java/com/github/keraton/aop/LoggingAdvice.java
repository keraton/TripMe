package com.github.keraton.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Aspect
@Component
public class LoggingAdvice {

    public LoggingAdvice() {
        System.out.println("Logging Advice");
    }

    @Around("@annotation(LoggingTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant before = Instant.now();

        Object proceed = joinPoint.proceed();

        System.out.println("[" + Thread.currentThread().getName() + "] Call duration " + joinPoint.getSignature() + " is " + (Instant.now().toEpochMilli() - before.toEpochMilli()) + " ms");

        return proceed;
    }
}

package com.example.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class LogAspect {
    @AfterReturning(pointcut = "execution(public * com.example.controller.BookController.*(..))")
    public void logHistory(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();

        System.err.println("method vua thuc hien xong la : "+name);
    }
//    @Pointcut("execution(* com.example.controller.BookController.*(..))")
//    public void allMethodPointCut() {
//    }
//
//    @Before("allMethodPointCut()")
//    public void beforeCallMethod(JoinPoint joinPoint) {
//        System.err.println("Start method name: " + joinPoint.getSignature().getName()
//                + " Times :" + LocalDate.now());
//    }
//
//    @AfterReturning("allMethodPointCut()")
//    public void afterReturningCallMethod(JoinPoint joinPoint) {
//        System.err.println("End method name: " + joinPoint.getSignature().getName()
//                + " Times: " + LocalDate.now());
//    }
}

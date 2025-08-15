package com.gyabisito.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect  {
    @Before("execution(* com.gyabisito.service.ProductServiceImpl.multiply(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Anntes de llamar al metodo");
    }
    @After("execution(* com.gyabisito.service.ProductServiceImpl.multiply(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("Anntes de llamar al metodo");
    }
}

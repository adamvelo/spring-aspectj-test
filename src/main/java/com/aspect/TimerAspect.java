package com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class TimerAspect {
  @Pointcut("@annotation(com.aspect.Timer)")
  public void timerPointcut() {}
  
  @Autowired
  public PojoForAspectInject pojo;

  @Around("timerPointcut() ")
  public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("Before proceed");
    pojo.pojo();
    Object obj = joinPoint.proceed();
    System.out.println("After proceed");
    return obj;
    
  }
}

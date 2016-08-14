package com.aspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@Configuration
@EnableAspectJAutoProxy
public class Main {
  
  @Bean
  public MyService getService() {
    return new MyService();
  }
  
  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.scan("com.aspect");
    ctx.refresh();
    MyService service = (MyService) ctx.getBean("myService");
    service.foo();
  }
}

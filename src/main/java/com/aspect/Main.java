package com.aspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class Main {
  
  @Bean 
  public PojoForAspectInject inj() {
    return new PojoForAspectInject();
  }
  
  @Bean
  public MyService myService() {
    return new MyService();
  }
  
  @Bean
  public TimerAspect aspect() {
    return new TimerAspect();
  }
  
  @SuppressWarnings("resource")
  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.scan("com.aspect");
    ctx.refresh();
    
    MyService service = (MyService) ctx.getBean("myService");
    for(String o : ctx.getBeansOfType(Object.class).keySet()) {
      System.out.println("bean: " + o);
    }
    System.out.println();
    service.foo();
  }
}

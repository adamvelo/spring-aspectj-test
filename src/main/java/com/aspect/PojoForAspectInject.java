package com.aspect;

import org.springframework.stereotype.Component;

public class PojoForAspectInject {
  public void pojo() {
    System.out.println("I am a pojo injected to aspect");
  }
}

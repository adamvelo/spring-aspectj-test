package com.aspect;

import org.springframework.stereotype.Service;

@Service
public class MyService {
  @Timer(value = "")
  public void foo() {
    System.out.println("I am foo.");
  }
}

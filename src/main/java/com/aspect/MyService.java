package com.aspect;

public class MyService {
  @Timer(value = "")
  public void foo() {
    System.out.println("I am foo.");
  }
}

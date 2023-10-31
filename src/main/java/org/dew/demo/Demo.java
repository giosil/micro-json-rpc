package org.dew.demo;

public class Demo {

  public String hello(String name) throws Exception {
    if(name == null || name.length() == 0) {
      throw new Exception("Missing name");
    }
    return "Hello " + name + "!";
  }

}

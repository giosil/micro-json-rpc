package org.dew.demo;

/**
 * Demo services.
 */
public class Demo {

  /**
   * hello service.
   * 
   * @param name Person name.
   * @return Greeting
   * @throws Exception
   */
  public String hello(String name) throws Exception {
    // Validation
    if(name == null || name.length() == 0) {
      throw new Exception("Missing name");
    }
    
    return "Hello " + name + "!";
  }

}

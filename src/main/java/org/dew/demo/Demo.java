package org.dew.demo;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Logger;

/**
 * Demo services.
 */
public class Demo {
  
  private static final Logger LOG = Logger.getLogger(Demo.class);
  
  /**
   * hello service.
   * 
   * @param name Person name.
   * @return Greeting
   * @throws Exception
   */
  public String hello(String name) throws Exception {
    LOG.debug("hello(" + name + ")...");
    // Validation
    if(name == null || name.length() == 0) {
      throw new Exception("Missing name");
    }
    
    return "Hello " + name + "!";
  }

  /**
   * helloObj service.
   * 
   * @param name Person name.
   * @return Greeting
   * @throws Exception
   */
  public Map<String, Object> helloObj(String name) throws Exception {
    LOG.debug("helloObj(" + name + ")...");
    // Validation
    if(name == null || name.length() == 0) {
      throw new Exception("Missing name");
    }
    
    Map<String, Object> result = new HashMap<>();
    
    result.put("intVal",     1);
    result.put("booleanVal", true);
    result.put("message",    "Hello " + name + "!");
    result.put("dateVal",    new Date(System.currentTimeMillis()));
    result.put("binaryVal",  name.getBytes());
    result.put("nullVal",    null);
    
    return result;
  }
}

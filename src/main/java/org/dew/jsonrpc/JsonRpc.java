package org.dew.jsonrpc;

import java.util.HashMap;
import java.util.Map;

import org.dew.demo.Demo;

// org.dew:wcollections:1.0.0
import org.dew.util.RefUtil;
import org.dew.util.WUtil;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * JSON-RPC Endpoint
 */
@Path("/rpc")
public class JsonRpc {

  public static final int PARSE_ERROR_CODE            = -32700;
  public static final int INVALID_REQUEST_ERROR_CODE  = -32600;
  public static final int METHOD_NOT_FOUND_ERROR_CODE = -32601;
  public static final int INVALID_PARAMS_ERROR_CODE   = -32602;
  public static final int INTERNAL_ERROR_CODE         = -32603;
  public static final int SERVER_ERROR_START          = -32000;
  
  /**
   * Handlers registration.
   */
  protected static Map<String, Object> handlers = new HashMap<>();
  static {
    handlers.put("DEMO", new Demo());
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return "Hello from JsonRpc.";
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public JsonRpcResponse invoke(JsonRpcRequest request) {
    if(request == null) {
      return new JsonRpcResponse(new JsonRpcError(INVALID_REQUEST_ERROR_CODE, "Invalid request"));
    }
    String methodName = request.getMethod();
    if(methodName == null || methodName.length() == 0) {
      return new JsonRpcResponse(new JsonRpcError(INVALID_REQUEST_ERROR_CODE, "Missing method"));
    }
    int sep = methodName.indexOf('.');
    if(sep <= 0) {
      return new JsonRpcResponse(new JsonRpcError(INVALID_REQUEST_ERROR_CODE, "Invalid method"));
    }
    
    String handlerName = methodName.substring(0,sep);
    methodName = methodName.substring(sep+1);
    
    Object handler = handlers.get(handlerName);
    if(handler == null) {
      return new JsonRpcResponse(new JsonRpcError(METHOD_NOT_FOUND_ERROR_CODE, "handler " + WUtil.toHTMLText(handlerName, "") + " not found"));
    }
    
    try {
      Object result = RefUtil.invoke(handler, methodName, request.getParams());
      
      return new JsonRpcResponse(request.getId(), result);
    }
    catch(Throwable ex) {
      return new JsonRpcResponse(request.getId(), new JsonRpcError(SERVER_ERROR_START, ex, RefUtil.getStackTrace(ex)));
    }
  }
}

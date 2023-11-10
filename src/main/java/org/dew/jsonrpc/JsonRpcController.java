package org.dew.jsonrpc;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * JSON-RPC Endpoint
 */
@Path("/rpc")
public class JsonRpcController {
  
  private static final Logger logger = LoggerFactory.getLogger(JsonRpcController.class);

  static {
    JsonRpc.addHandler("DEMO", new org.dew.demo.Demo());
  }

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    logger.info("JsonRpcController.hello");
    return "Hello from JsonRpc.";
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public JsonRpcResponse invoke(JsonRpcRequest request) {
    return JsonRpc.invoke(request);
  }

}

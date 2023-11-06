package org.dew.jsonrpc;

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
public class JsonRpcService {

  static {
    JsonRpc.addHandler("DEMO", new org.dew.demo.Demo());
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
    return JsonRpc.invoke(request);
  }
}

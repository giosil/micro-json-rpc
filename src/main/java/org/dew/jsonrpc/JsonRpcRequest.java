package org.dew.jsonrpc;

import java.io.Serializable;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Bean JsonRpcRequest.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonRpcRequest implements Serializable {

  private static final long serialVersionUID = 1721139321748128545L;
  
  protected int id;
  protected String jsonrpc;
  protected String method;
  protected List<Object> params;

  public JsonRpcRequest()
  {
    this.jsonrpc = "2.0";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getJsonrpc() {
    return jsonrpc;
  }

  public void setJsonrpc(String jsonrpc) {
    this.jsonrpc = jsonrpc;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public List<Object> getParams() {
    return params;
  }

  public void setParams(List<Object> params) {
    this.params = params;
  }
  
  @Override
  public boolean equals(Object object) {
    if(object instanceof JsonRpcRequest) {
      return this.toString().equals(object.toString());
    }
    return false;
  }
  
  @Override
  public int hashCode() {
    return toString().hashCode();
  }
  
  @Override
  public String toString() {
    if(params == null) return id + "#" + method + "#0";
    return id + "#" + method + "#" + params.size();
  }
}

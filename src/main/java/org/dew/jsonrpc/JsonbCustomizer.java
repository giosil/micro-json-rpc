package org.dew.jsonrpc;

import io.quarkus.jsonb.JsonbConfigCustomizer;

import jakarta.inject.Singleton;

import jakarta.json.bind.JsonbConfig;

import jakarta.json.bind.config.BinaryDataStrategy;

@Singleton
public class JsonbCustomizer implements JsonbConfigCustomizer {

  public void customize(JsonbConfig config) {
    config
      .withNullValues(false)
      .withBinaryDataStrategy(BinaryDataStrategy.BASE_64);
  }

}

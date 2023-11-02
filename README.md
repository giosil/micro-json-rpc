# micro-json-rpc

Implementation of JSON-RPC protocol based on Quarkus microservice.

> As much as possible Quarkus tries to avoid reflection, reducing startup time and memory usage.
>
> from https://quarkus.io/container-first

This library necessarily uses reflection.

This project therefore intends to provide a tool for migrating monolithic software towards microservice architectures.

The project was created with the following command:

`quarkus create app org.dew.jsonrpc:micro-json-rpc --extension='resteasy-reactive-jackson'`


## Build with Maven

- `git clone https://github.com/giosil/micro-json-rpc.git`
- `mvn clean install`

## Build with Quarkus

- `git clone https://github.com/giosil/micro-json-rpc.git`
- `quarkus build`

## Run

- `quarkus dev`

## Contributors

* [Giorgio Silvestris](https://github.com/giosil)
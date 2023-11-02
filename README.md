# micro-json-rpc

Implementation of JSON-RPC protocol based on Quarkus microservice.

> As much as possible Quarkus tries to avoid reflection, reducing startup time and memory usage.
>
> *from https://quarkus.io/container-first*

This library necessarily uses reflection.

This project therefore intends to provide a tool for migrating monolithic software towards microservice architectures.

## Dependencies

**wcollections**

- `git clone https://github.com/giosil/wcollections.git` 
- `mvn clean install` - this will publish `wcollections-1.0.0.jar` in Maven local repository

## Quarkus usage

The project was created with the following command:

`quarkus create app org.dew.jsonrpc:micro-json-rpc --extension='resteasy-reactive-jackson'`

If you want to add a connection pool to a DBMS:

`quarkus ext add io.quarkus:quarkus-agroal`

This command inserts a new dependency into the pom.xml file

```xml
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-agroal</artifactId>
    </dependency>
```

To consult the list of dependencies:

`quarkus ext list`

or simply:

`quarkus ext`

To remove a dependency:

`quarkus ext remove io.quarkus:quarkus-agroal`

## Build with Maven

- `git clone https://github.com/giosil/micro-json-rpc.git`
- `mvn clean install`

## Build with Quarkus

- `git clone https://github.com/giosil/micro-json-rpc.git`
- `quarkus build`

Build a native executable:

- `quarkus build --native`

Build a container friendly executable:

- `quarkus build --native -Dquarkus.native.container-build=true`

## Run in development mode

- `quarkus dev`

To enable debug:

- `quarkus dev -Dsuspend -Ddebug` - Then, attach your debugger to localhost:5005.

## Datasource configuration

Edit `src/main/resources/application.properties`:

```
quarkus.datasource.db-kind=mariadb
quarkus.datasource.username=user
quarkus.datasource.password=password
quarkus.datasource.jdbc.url=jdbc:mariadb://localhost:3306/database
quarkus.datasource.jdbc.min-size=5
quarkus.datasource.jdbc.max-size=20
quarkus.datasource.jdbc.connection-timeout=5s
```

## Contributors

* [Giorgio Silvestris](https://github.com/giosil)
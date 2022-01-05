package com.brownhash.vertxdemo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

import java.util.Properties;

import com.brownhash.vertxdemo.rest.Routes;

public class MainVerticle extends AbstractVerticle {

  // import project properties
  final Properties properties = new Properties();
  String appName;
  String appVersion;

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    properties.load(this.getClass().getClassLoader().getResourceAsStream("application.properties"));
    this.appName = properties.getProperty("name");
    this.appVersion = properties.getProperty("version");

    HttpServer server = vertx.createHttpServer();
    Router router = Router.router(vertx);

    new Routes("v1", router, this.appName, this.appVersion);

    server.requestHandler(router).listen(8080, http -> {
      if (http.succeeded()) {
        System.out.println("HTTP server started on port 8080");
      } else {
        startPromise.fail(http.cause());
      }
    });
  }
}

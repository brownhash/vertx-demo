package com.brownhash.vertxdemo.rest;

import io.vertx.ext.web.Router;

import com.brownhash.vertxdemo.rest.v1.V1;

public class Routes {
    public Routes(String apiVersion, Router router, String appName, String appVersion) {
      if (apiVersion == "v1") {
        new V1(router, "/api", appName, appVersion);
      }
    }
}

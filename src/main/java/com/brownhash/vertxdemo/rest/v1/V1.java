package com.brownhash.vertxdemo.rest.v1;

import io.vertx.ext.web.Router;

import com.brownhash.vertxdemo.rest.v1.system.System;

public class V1 {
  public V1(Router router, String rootPath, String appName, String appVersion) {
    new System(router, rootPath + "/v1", appName, appVersion);
  }
}

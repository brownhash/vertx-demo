package com.brownhash.vertxdemo.rest.v1.system;

import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

public class System {
  public System(Router router, String rootPath, String appName, String appVersion) {
    router
      .get(rootPath + "/system")
      .respond(
        ctx -> Future.succeededFuture(new JsonObject().put(appName, appVersion)));
  }
}

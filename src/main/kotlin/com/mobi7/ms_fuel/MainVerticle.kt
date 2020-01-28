package com.mobi7.ms_fuel

import io.vertx.core.AbstractVerticle
import io.vertx.ext.mongo.MongoClient
import io.vertx.kotlin.core.json.json
import io.vertx.kotlin.core.json.obj

class MainVerticle : AbstractVerticle() {
  private val config = json {
    obj(
      "connection_string" to "mongodb://root:example@127.0.0.1:27017/"
    )
  }

  override fun start() {
    val mongoClient = MongoClient.create(vertx, config)

    val service: FuelService = FuelService(mongoClient)
    vertx.createHttpServer()
      .requestHandler { req ->
        req.response()
          .putHeader("content-type", "application/json")
          .end("${service.saveFuel()}")
      }.listen(8080)
  }
}

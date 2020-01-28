package com.mobi7.ms_fuel

import io.vertx.core.AbstractVerticle
import io.vertx.ext.mongo.MongoClient
import io.vertx.kotlin.core.json.*

class MainVerticle : AbstractVerticle() {
  private val config = json {
    obj(
      "connection_string" to "mongodb://localhost:27017",
      "db_name" to "my_db"
    )
  }
  private val mongoClient = MongoClient.create(vertx, config)
  private var service: FuelService = FuelService(mongoClient)


  override fun start() {
    vertx.createHttpServer()
      .requestHandler { req ->
        req.response()
          .putHeader("content-type", "application/json")
          .end("${service.saveFuel()}")
      }.listen(8080)
  }
}

package com.mobi7.ms_fuel.dao

import com.mobi7.ms_fuel.model.Fuelling
import io.vertx.core.Handler
import io.vertx.core.json.JsonObject
import io.vertx.ext.mongo.MongoClient


class FuelDAO(mongoClient: MongoClient) {
  private val dbInstance = mongoClient

  fun save(): Fuelling {
    val data = Fuelling(1)
    val document =
      JsonObject()
        .put("id", 1)
        .put("description", "Test")
    dbInstance.save("fuel", document, Handler { event ->
      if (event.succeeded()) {
        println("Saved fuel with id ${event.result()}");
      } else {
        event.cause().printStackTrace();
      }
    })

    return data
  }
}

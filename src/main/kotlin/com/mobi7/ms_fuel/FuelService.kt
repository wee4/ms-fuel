package com.mobi7.ms_fuel

import com.mobi7.ms_fuel.dao.FuelDAO
import com.mobi7.ms_fuel.model.Fuelling
import io.vertx.ext.mongo.MongoClient

class FuelService(mongoClient: MongoClient) {
  private val dao = FuelDAO(mongoClient)

  fun saveFuel(): Fuelling {
    return dao.save()
  }
}

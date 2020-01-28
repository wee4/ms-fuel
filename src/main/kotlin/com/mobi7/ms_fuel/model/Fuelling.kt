package com.mobi7.ms_fuel.model

import java.util.*

data class Fuelling(
  val id: Int,
  val description: String = "Test 1",
  val locale: String = "Here",
  val coast: Double = 5.0,
  val date: Date = Date(),
  val user: User = User(1, "Test User"),
  val vehicle: Vehicle = Vehicle(1)
)

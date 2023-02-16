package com.example.csc415

data class Headphone(
    val name: String,
    val image: String,
    val brand: String,
    val price: Int,
    val weight: Int = 400,
    val driverType: String = "Dynamic",
    val impedance: Int = 32,
    val sensitivity: Int = 100
)

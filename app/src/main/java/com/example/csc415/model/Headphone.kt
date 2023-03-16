package com.example.csc415.model

data class Headphone(
    val id: Int,
    val name: String,
    val image: String,
    val brand: String,
    val price: Int,
    val weight: Int = 400,
    val driverType: String = "Dynamic",
    val impedance: Int = 32,
    val sensitivity: Int = 100
)

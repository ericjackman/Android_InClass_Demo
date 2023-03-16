package com.example.csc415.ViewModel

import androidx.lifecycle.ViewModel
import com.example.csc415.model.Headphone

class HeadphoneViewModel : ViewModel() {
    private val headphones: MutableList<Headphone> = mutableListOf<Headphone>()

    init {
        createHeadphones()
    }

    fun fillData() = headphones.toList()

    fun fetchByID(id: Int) = headphones.first { it.id == id }

    private fun createHeadphones() {
        headphones.add(
            Headphone(
                id = 0,
                name = "Sundara",
                image = "https://m.media-amazon.com/images/I/61eJhLsaV0L.jpg",
                brand = "Hifiman",
                price = 300,
                weight = 320,
                driverType = "Planar",
                impedance = 35,
                sensitivity = 94
            )
        )
        headphones.add(
            Headphone(
                id = 1,
                name = "Elegia",
                image = "https://m.media-amazon.com/images/I/61QG3++KTUL.jpg",
                brand = "Focal",
                price = 400,
                weight = 380,
                driverType = "Dynamic",
                impedance = 32,
                sensitivity = 105
            )
        )
        headphones.add(
            Headphone(
                id = 2,
                name = "Aeon 2 Noire",
                image = "https://m.media-amazon.com/images/I/51aR7GX0q3L._AC_UF894,1000_QL80_.jpg",
                brand = "Dan Clark Audio",
                price = 900,
                weight = 300,
                driverType = "Planar",
                impedance = 12,
                sensitivity = 91
            )
        )
        headphones.add(
            Headphone(
                id = 3,
                name = "LCD-2",
                image = "https://m.media-amazon.com/images/I/81o0PAuncdL._AC_SL1500_.jpg",
                brand = "Audeze",
                price = 800,
                weight = 600,
                driverType = "Planar"
            )
        )
        headphones.add(
            Headphone(
                id = 4,
                name = "HD 800s",
                image = "https://m.media-amazon.com/images/I/710Zn2k1hLL.jpg",
                brand = "Sennheiser",
                price = 1600,
                weight = 320,
                driverType = "Dynamic"
            )
        )
        headphones.add(
            Headphone(
                id = 5,
                name = "Clear MG",
                image = "https://m.media-amazon.com/images/I/71yBEU79dGL._AC_SX466_.jpg",
                brand = "Focal",
                price = 1500,
                weight = 450,
                driverType = "Dynamic"
            )
        )
    }
}
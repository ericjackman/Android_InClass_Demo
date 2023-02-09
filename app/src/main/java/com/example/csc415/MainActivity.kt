package com.example.csc415

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.headphone_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val headphones = createHeadphones()

        val adapter = HeadphoneAdapter(headphones)
        recyclerView.adapter = adapter
    }

    private fun createHeadphones() : MutableList<Headphone> {
        val headphones = mutableListOf<Headphone>()
        headphones.add(Headphone(name = "Sundara", image = R.mipmap.hifiman_sundara, brand = "Hifiman"))
        headphones.add(Headphone(name = "Elegia", image = R.mipmap.hifiman_sundara, brand = "Focal"))
        headphones.add(Headphone(name = "Aeon 2 Noire", image = R.mipmap.hifiman_sundara, brand = "Dan Clark Audio"))
        headphones.add(Headphone(name = "LCD-2", image = R.mipmap.hifiman_sundara, brand = "Audeze"))
        headphones.add(Headphone(name = "DT 1990", image = R.mipmap.hifiman_sundara, brand = "Beyerdynamic"))
        headphones.add(Headphone(name = "HD 600", image = R.mipmap.hifiman_sundara, brand = "Sennheiser"))
        headphones.add(Headphone(name = "109 Pro", image = R.mipmap.hifiman_sundara, brand = "Meze"))
        return headphones
    }
}

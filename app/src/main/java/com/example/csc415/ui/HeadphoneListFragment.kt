package com.example.csc415.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.csc415.Headphone
import com.example.csc415.HeadphoneAdapter
import com.example.csc415.R

class HeadphoneListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_headphone_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.headphone_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val headphones = createHeadphones()

        val adapter = HeadphoneAdapter(headphones)
        recyclerView.adapter = adapter

        return view
    }

    // create a list of headphone objects to display in the recycler view
    private fun createHeadphones(): MutableList<Headphone> {
        val headphones = mutableListOf<Headphone>()
        headphones.add(
            Headphone(
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
                name = "Clear MG",
                image = "https://m.media-amazon.com/images/I/71yBEU79dGL._AC_SX466_.jpg",
                brand = "Focal",
                price = 1500,
                weight = 450,
                driverType = "Dynamic"
            )
        )
        return headphones
    }
}

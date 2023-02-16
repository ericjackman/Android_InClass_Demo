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
                image = R.mipmap.hifiman_sundara,
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
                image = R.mipmap.focal_elegia,
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
                image = R.mipmap.dca_aeon2,
                brand = "Dan Clark Audio",
                price = 900
            )
        )
        headphones.add(
            Headphone(
                name = "LCD-2",
                image = R.mipmap.audeze_lcd2,
                brand = "Audeze",
                price = 800
            )
        )
        headphones.add(
            Headphone(
                name = "DT 1990",
                image = R.mipmap.deyer_dt1990,
                brand = "Beyerdynamic",
                price = 500
            )
        )
        headphones.add(
            Headphone(
                name = "HD 600",
                image = R.mipmap.sennheiser_hd600,
                brand = "Sennheiser",
                price = 300
            )
        )
        headphones.add(
            Headphone(
                name = "109 Pro",
                image = R.mipmap.meze_109pro,
                brand = "Meze",
                price = 800
            )
        )
        return headphones
    }
}

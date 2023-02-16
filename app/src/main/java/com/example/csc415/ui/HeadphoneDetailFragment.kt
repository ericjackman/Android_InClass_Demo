package com.example.csc415.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.csc415.R

class HeadphoneDetailFragment : Fragment() {

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_headphone_detail, container, false)

        if (arguments != null) {
            val name = requireArguments().getString("name")
            val brand = requireArguments().getString("brand")
            val image = requireArguments().getInt("image")
            val price = requireArguments().getInt("price")
            val weight = requireArguments().getInt("weight")
            val driver = requireArguments().getString("driver")
            val imp = requireArguments().getInt("impedance")
            val sens = requireArguments().getInt("sensitivity")

//            Glide
//                .with(this)
//                .load(image)
//                .into(view.findViewById<ImageView>(R.id.headphone_detail_image))
            view.findViewById<ImageView>(R.id.headphone_detail_image).setImageResource(image)
            view.findViewById<TextView>(R.id.headphone_detail_name).text = "$brand $name"
            view.findViewById<TextView>(R.id.headphone_detail_price).text = "Price: \$$price"
            view.findViewById<TextView>(R.id.headphone_detail_weight).text = "Weight: $weight grams"
            view.findViewById<TextView>(R.id.headphone_detail_driver).text = "Driver Type: $driver"
            view.findViewById<TextView>(R.id.headphone_detail_imp).text = "Impedance: $imp ohms"
            view.findViewById<TextView>(R.id.headphone_detail_sens).text = "Sensitivity: $sens dB"
        }

        return view
    }
}
package com.example.secondproject.MenuScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.secondproject.R

class MenuFragment : Fragment() {
    private lateinit var btnFood: Button
    private lateinit var btnCafe: Button
    private lateinit var btnDessert: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        btnFood = view.findViewById(R.id.btnFood)
        btnCafe = view.findViewById(R.id.btnCafe)
        btnDessert = view.findViewById(R.id.btnDessert)

        // Set default fragment to FoodScreen
        loadFragment(FoodFragment())

        // Set up button click listeners to load corresponding fragments
        btnFood.setOnClickListener {
            loadFragment(FoodFragment())
        }

        btnCafe.setOnClickListener {
            loadFragment(CafeFragment())
        }

        btnDessert.setOnClickListener {
            loadFragment(DessertFragment())
        }

        return view
    }

    private fun loadFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }
}
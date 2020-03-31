package com.mp.covid19.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import com.mp.covid19.R
import kotlinx.android.synthetic.main.fragment_carantin.view.*
import kotlinx.android.synthetic.main.fragment_symptoms.view.*

class SymptomsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding : View = inflater.inflate(R.layout.fragment_symptoms, container, false)

        binding.to_location_button.setOnClickListener {
                view : View ->
            view.findNavController().navigate(R.id.action_symptomsFragment_to_locationFragment)
        }


        return binding.rootView
    }
}

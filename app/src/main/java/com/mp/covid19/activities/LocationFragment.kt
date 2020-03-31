package com.mp.covid19.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.mp.covid19.R
import kotlinx.android.synthetic.main.fragment_location.view.*


class LocationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding : View = inflater.inflate(R.layout.fragment_location, container, false)

        binding.to_personal_data_button.setOnClickListener {
                view : View ->
            view.findNavController().navigate(R.id.action_locationFragment_to_personalDataFragment)
        }

        return binding.rootView
    }
}

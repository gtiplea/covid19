package com.mp.covid19.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.navigation.findNavController

import com.mp.covid19.R

import kotlinx.android.synthetic.main.fragment_carantin.view.*

class CarantinFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding : View = inflater.inflate(R.layout.fragment_carantin, container, false)

        binding.to_contact_button.setOnClickListener {
            view : View ->
            view.findNavController().navigate(R.id.action_carantinFragment_to_contactFragment)
        }
        return binding.rootView
    }

}

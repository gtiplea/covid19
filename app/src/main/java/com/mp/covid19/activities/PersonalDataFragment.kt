package com.mp.covid19.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mp.covid19.R
import kotlinx.android.synthetic.main.fragment_personal_data.view.*
import androidx.navigation.findNavController
class PersonalDataFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding : View = inflater.inflate(R.layout.fragment_personal_data, container, false)

        binding.to_finish_button.setOnClickListener {
                view : View ->
            view.findNavController().navigate(R.id.action_personalDataFragment_to_endScreen)
        }


        return binding.rootView
    }
}
package com.mp.covid19.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.google.gson.Gson
import com.mp.covid19.R
import com.mp.covid19.models.FormData
import com.mp.covid19.models.PersonalData
import kotlinx.android.synthetic.main.fragment_location.*
import kotlinx.android.synthetic.main.fragment_location.view.*


class LocationFragment : Fragment() {
    private lateinit var binding : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = inflater.inflate(R.layout.fragment_location, container, false)

        binding.to_personal_data_button.setOnClickListener {
                view : View ->
            view.findNavController().navigate(R.id.action_locationFragment_to_personalDataFragment, getFormDataBundle())
        }

        return binding.rootView
    }

    fun getFormDataBundle(): Bundle {
        var formData = Gson().fromJson(arguments?.getString("formData"), FormData::class.java)
        val locationString = locationTextInput.text

        if (!locationString.isNullOrBlank()) {
            formData.personalData = PersonalData(locationString.toString(), null, null, null)
        }
        return bundleOf("formData" to Gson().toJson(formData))
    }
}

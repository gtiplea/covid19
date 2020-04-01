package com.mp.covid19.activities

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf

import com.mp.covid19.R
import kotlinx.android.synthetic.main.fragment_personal_data.view.*
import androidx.navigation.findNavController
import com.google.gson.Gson
import com.mp.covid19.models.FormData
import com.mp.covid19.models.PersonalData

class PersonalDataFragment : Fragment() {
    private lateinit var binding : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = inflater.inflate(R.layout.fragment_personal_data, container, false)

        binding.to_finish_button.setOnClickListener {
                view : View ->
            view.findNavController().navigate(R.id.action_personalDataFragment_to_endScreen, getFormDataBundle())
        }


        return binding.rootView
    }

    fun getFormDataBundle(): Bundle{
        var formData = Gson().fromJson(arguments?.getString("formData"), FormData::class.java)
        val name = binding.nameEditText.text
        val phoneNumber = binding.phoneNumberEditText.text
        val healthCardNumber = binding.healthCardEditText.text

        if (!name.isNullOrBlank()) {
            if (formData.personalData == null) {
                formData.personalData = PersonalData(null, null, null, null)
            }
            formData.personalData?.name = name.toString()
        }
        if (!phoneNumber.isNullOrBlank()) {
            if (formData.personalData == null) {
                formData.personalData = PersonalData(null, null, null, null)
            }
            formData.personalData?.phoneNumber = phoneNumber.toString()
        }
        if (!healthCardNumber.isNullOrBlank()) {
            if (formData.personalData == null) {
                formData.personalData = PersonalData(null, null, null, null)
            }
            formData.personalData?.healthCard = healthCardNumber.toString()
        }
        return bundleOf("formData" to Gson().toJson(formData))
    }
}

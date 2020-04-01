package com.mp.covid19.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.google.gson.Gson

import com.mp.covid19.R
import com.mp.covid19.models.FormData
import com.mp.covid19.models.Symptoms
import kotlinx.android.synthetic.main.fragment_carantin.view.*
import kotlinx.android.synthetic.main.fragment_symptoms.view.*

class SymptomsFragment : Fragment() {
    private lateinit var binding : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = inflater.inflate(R.layout.fragment_symptoms, container, false)

        binding.to_location_button.setOnClickListener {
                view : View ->
            view.findNavController().navigate(R.id.action_symptomsFragment_to_locationFragment, getFormDataBundle())
        }

        return binding.rootView
    }

    fun getFormDataBundle(): Bundle{
        var formData = Gson().fromJson(arguments?.getString("formData"), FormData::class.java)
        if (binding.SymptomCough.isChecked) {
            if (formData.symptoms == null) {
                formData.symptoms = mutableListOf()
            }
            formData.symptoms?.add(Symptoms.COUGH)
        }
        if (binding.SymptomFever.isChecked) {
            if (formData.symptoms == null) {
                formData.symptoms = mutableListOf()
            }
            formData.symptoms?.add(Symptoms.FEVER)
        }
        if (binding.SymptomTired.isChecked) {
            if (formData.symptoms == null) {
                formData.symptoms = mutableListOf()
            }
            formData.symptoms?.add(Symptoms.TIREDNESS)
        }
        if (binding.SymptomDifficultyBreathing.isChecked) {
            if (formData.symptoms == null) {
                formData.symptoms = mutableListOf()
            }
            formData.symptoms?.add(Symptoms.HEAVY_BREATHING)
        }
        return bundleOf("formData" to Gson().toJson(formData))
    }
}

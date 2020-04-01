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
import kotlinx.android.synthetic.main.fragment_contacts.view.*
import java.text.Normalizer

class ContactFragment : Fragment() {
    private lateinit var binding : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = inflater.inflate(R.layout.fragment_contacts, container, false)

        // this bad boy does the sequence switching
        val value = arguments?.getInt("amount")
        binding.to_symptoms_button.setOnClickListener {
                view : View ->
                view.findNavController().navigate(R.id.action_contactFragment_to_symptomsFragment, getFormDataBundle())
        }


        return binding.rootView
    }

    fun getFormDataBundle(): Bundle {
        var formData = Gson().fromJson(arguments?.getString("formData"), FormData::class.java)
        when (binding.carantinChoiceGroup.checkedRadioButtonId) {
            R.id.ContactNegativ -> formData.hadContactWithSuspectPeople = false
            R.id.ContactPositiv -> formData.hadContactWithSuspectPeople = true
        }
        return bundleOf("formData" to Gson().toJson(formData))
    }
}
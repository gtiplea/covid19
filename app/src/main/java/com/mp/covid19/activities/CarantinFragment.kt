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
import com.mp.covid19.models.IsolationLevel

import kotlinx.android.synthetic.main.fragment_carantin.view.*
import java.text.Normalizer

class CarantinFragment : Fragment() {
    private lateinit var binding : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = inflater.inflate(R.layout.fragment_carantin, container, false)

        binding.to_contact_button.setOnClickListener {
            view : View ->
            view.findNavController().navigate(R.id.action_carantinFragment_to_contactFragment, getFormDataBundle())
        }
        return binding.rootView
    }

    fun getFormDataBundle(): Bundle{
        var formData: FormData = FormData(null, null, null, null)
        when (binding.carantinChoiceGroup.checkedRadioButtonId) {
            R.id.autoizolare -> formData.isolationLevel = IsolationLevel.AUTO_ISOLATION
            R.id.izolare -> formData.isolationLevel = IsolationLevel.ISOLATION
            R.id.carantina -> formData.isolationLevel = IsolationLevel.CARANTINE
        }
        return bundleOf("formData" to Gson().toJson(formData))
    }

}

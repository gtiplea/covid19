package com.mp.covid19.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson

import com.mp.covid19.R
import com.mp.covid19.models.FormData
import com.mp.covid19.services.FirebaseRealTimeDatabaseService
import java.util.logging.Logger

class EndScreen : Fragment() {
    private lateinit var binding : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = inflater.inflate(R.layout.fragment_end_screen, container, false)
        saveFormData()

        return binding.rootView
    }

    fun saveFormData() {
        val formData = Gson().fromJson(arguments?.getString("formData"), FormData::class.java)
        FirebaseRealTimeDatabaseService.saveFormData(formData)
    }
}
package com.mp.covid19.services

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.mp.covid19.models.FormData
import java.util.UUID

class FirebaseRealTimeDatabaseService {
    companion object {
        private val database = Firebase.database.reference

        fun saveFormData(formData: FormData) {
            database.child("forms").child(UUID.randomUUID().toString()).setValue(formData)
        }
    }
}
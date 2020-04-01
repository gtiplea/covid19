package com.mp.covid19.models

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class PersonalData (
    var address: String?,
    var name: String?,
    var phoneNumber: String?,
    var healthCard: String?
)
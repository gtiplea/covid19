package com.mp.covid19.models

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class FormData (
    var isolationLevel: IsolationLevel?,
    var hadContactWithSuspectPeople: Boolean?,
    var symptoms: MutableList<Symptoms>?,
    var personalData: PersonalData?
)
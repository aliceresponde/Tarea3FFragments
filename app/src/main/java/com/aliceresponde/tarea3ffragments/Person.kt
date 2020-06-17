package com.aliceresponde.tarea3ffragments

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    val name: String,
    val age: Int,
    val email: String
) : Parcelable
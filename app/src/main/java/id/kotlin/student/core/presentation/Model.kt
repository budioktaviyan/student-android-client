package id.kotlin.student.core.presentation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Model(val message: String) : Parcelable
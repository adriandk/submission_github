package com.adrian.consumerapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
    var id : Int = 0,
    var name : String? = null,
    var image : String? = null
) : Parcelable
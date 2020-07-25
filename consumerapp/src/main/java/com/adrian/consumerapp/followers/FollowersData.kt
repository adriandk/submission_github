package com.adrian.consumerapp.followers

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FollowersData(
    var name : String? = null,
    var type : String? = null,
    var image : String? = null
) : Parcelable
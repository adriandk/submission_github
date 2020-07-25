package com.example.githubapp.following

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FollowingData(
    var name : String? = null,
    var type : String? = null,
    var image : String? = null
) : Parcelable
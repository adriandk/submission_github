package com.example.githubapp.favorite

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FavoriteData(
    var id : Int = 0,
    var name : String? = null,
    var image : String? = null
) : Parcelable
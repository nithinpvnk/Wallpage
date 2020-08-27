package com.techdining.www.wallpage.dataModel

import com.google.gson.annotations.SerializedName

data class ProfileImage(
    @field:SerializedName("small") val smallProfileImage: String,
    @field:SerializedName("medium") val mediumProfileImage: String,
    @field:SerializedName("large") val largeProfileImage: String
)

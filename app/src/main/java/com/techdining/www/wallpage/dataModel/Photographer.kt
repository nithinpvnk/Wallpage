package com.techdining.www.wallpage.dataModel

import com.google.gson.annotations.SerializedName

data class Photographer(
    @field:SerializedName("name") val name: String,
    @field:SerializedName("bio") val bio: String?,
    @field:SerializedName("profile_image") val profileImage: ProfileImage,
    @field:SerializedName("links") val workCollection: WorkCollection
)

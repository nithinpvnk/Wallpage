package com.techdining.www.wallpage.dataModel

import com.google.gson.annotations.SerializedName

data class TypeOfUrls(
    @field:SerializedName("raw") val rawImageUrl: String,
    @field:SerializedName("full") val fullImageUrl: String,
    @field:SerializedName("regular") val regularImageUrl: String,
    @field:SerializedName("small") val smallImageUrl: String,
    @field:SerializedName("thumb") val thumbnailImageUrl: String
)

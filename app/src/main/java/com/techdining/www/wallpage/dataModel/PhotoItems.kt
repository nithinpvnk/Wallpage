package com.techdining.www.wallpage.dataModel

import com.google.gson.annotations.SerializedName

data class PhotoItems(
    @field:SerializedName("id") val id: String,
    @field:SerializedName("width") val width: Int,
    @field:SerializedName("height") val height: Int,
    @field:SerializedName("color") val color: String,
    @field:SerializedName("description") val description: String,
    @field:SerializedName("alt_description") val alt_description: String,
    @field:SerializedName("urls") val typesOfUrls: TypeOfUrls,
    @field:SerializedName("likes") val likes: Int,
    @field:SerializedName("user") val photographer: Photographer

)
package com.techdining.www.wallpage.dataModel

import com.google.gson.annotations.SerializedName

data class WorkCollection(
    @field:SerializedName("photos") val picturesClicked: String
)
package com.example.melimarketplace.data.model.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseDetailData(
    @Json(name = "body")
    val body: BodyDetailData? = null
)

package com.example.melimarketplace.data.model.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PictureData(
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "max_size")
    val maxSize: String? = null,
    @Json(name = "quality")
    val quality: String? = null,
    @Json(name = "secure_url")
    val secureUrl: String? = null,
    @Json(name = "size")
    val size: String? = null,
    @Json(name = "url")
    val url: String? = null
)
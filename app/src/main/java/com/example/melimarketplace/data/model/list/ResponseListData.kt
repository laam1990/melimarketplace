package com.example.melimarketplace.data.model.list

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseListData(
    @Json(name = "results")
    val results: List<ResultsData>? = null
)

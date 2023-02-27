package com.example.melimarketplace.data.model.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BodyDetailData(
    @Json(name = "attributes")
    val attributes: List<AttributeData>? = null,
    @Json(name = "base_price")
    val basePrice: Int? = null,
    @Json(name = "condition")
    val condition: String? = null,
    @Json(name = "currency_id")
    val currencyId: String? = null,
    @Json(name = "date_created")
    val dateCreated: String? = null,
    @Json(name = "domain_id")
    val domainId: String? = null,
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "pictures")
    val pictures: List<PictureData>? = null,
    @Json(name = "price")
    val price: Int? = null,
    @Json(name = "secure_thumbnail")
    val secureThumbnail: String? = null,
    @Json(name = "status")
    val status: String? = null,
    @Json(name = "tags")
    val tags: List<String>? = null,
    @Json(name = "thumbnail")
    val thumbnail: String? = null,
    @Json(name = "thumbnail_id")
    val thumbnailId: String? = null,
    @Json(name = "title")
    val title: String? = null
)
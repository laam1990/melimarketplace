package com.example.melimarketplace.data.model.list

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResultsData(
    @Json(name = "accepts_mercadopago")
    val acceptsMercadoPago: Boolean? = null,
    @Json(name = "attributes")
    val attributes: List<AttributeData>? = null,
    @Json(name = "available_quantity")
    val availableQuantity: Double? = null,
    @Json(name = "buying_mode")
    val buyingMode: String? = null,
    @Json(name = "category_id")
    val categoryId: String? = null,
    @Json(name = "condition")
    val condition: String? = null,
    @Json(name = "currency_id")
    val currencyId: String? = null,
    @Json(name = "domain_id")
    val domainId: String? = null,
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "listing_type_id")
    val listingTypeId: String? = null,
    @Json(name = "order_backend")
    val orderBackend: Int? = null,
    @Json(name = "original_price")
    val originalPrice: Double? = null,
    @Json(name = "permalink")
    val permalink: String? = null,
    @Json(name = "price")
    val price: Double? = null,
    @Json(name = "thumbnail")
    val thumbnail: String? = null,
    @Json(name = "thumbnail_id")
    val thumbnailId: String? = null,
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "use_thumbnail_id")
    val useThumbnailId: Boolean? = null
)
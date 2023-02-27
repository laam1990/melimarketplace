package com.example.melimarketplace.data.model.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AttributeData(
    @Json(name = "attribute_group_id")
    val attributeGroupId: String? = null,
    @Json(name = "attribute_group_name")
    val attributeGroupName: String? = null,
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "value_id")
    val valueId: String? = null,
    @Json(name = "value_name")
    val valueName: String? = null,
    @Json(name = "value_type")
    val valueType: String? = null
)
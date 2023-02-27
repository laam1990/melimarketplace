package com.example.melimarketplace.ui.model

data class DetailViewData(
    val id: String,
    val pictures: List<PictureViewData>,
    val title: String,
    val price: Int,
    val condition: String
)
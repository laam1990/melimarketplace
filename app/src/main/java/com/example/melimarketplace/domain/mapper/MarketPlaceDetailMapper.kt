package com.example.melimarketplace.domain.mapper

import com.example.melimarketplace.data.model.detail.PictureData
import com.example.melimarketplace.data.model.detail.ResponseDetailData
import com.example.melimarketplace.domain.util.Mapper
import com.example.melimarketplace.ui.model.DetailViewData
import com.example.melimarketplace.ui.model.PictureViewData
import javax.inject.Inject

class MarketPlaceDetailMapper @Inject constructor() :
    Mapper<DetailViewData, List<ResponseDetailData>> {

    override fun executeMapping(type: List<ResponseDetailData>): DetailViewData {
        type.first().body.let { data ->
            return DetailViewData(
                id = data?.id.orEmpty(),
                title = data?.title.orEmpty(),
                price = data?.price ?: 0,
                condition = data?.condition.orEmpty(),
                pictures = parsePictureViewData(data?.pictures)
            )
        }
    }

    private fun parsePictureViewData(pictures: List<PictureData>?): List<PictureViewData> {
        return pictures.orEmpty().map {
            PictureViewData(
                imageUrl = it.secureUrl.orEmpty()
            )
        }
    }
}
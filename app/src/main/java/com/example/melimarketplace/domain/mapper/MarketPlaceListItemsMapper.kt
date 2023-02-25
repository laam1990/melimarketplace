package com.example.melimarketplace.domain.mapper

import com.example.melimarketplace.data.model.list.ResultsData
import com.example.melimarketplace.data.model.list.ResponseListData
import com.example.melimarketplace.domain.util.Mapper
import com.example.melimarketplace.ui.model.ResponseListViewData
import com.example.melimarketplace.ui.model.ResultItemViewData
import javax.inject.Inject
import kotlin.math.roundToInt

class MarketPlaceListItemsMapper @Inject constructor() :
    Mapper<ResponseListViewData, ResponseListData> {

    override fun executeMapping(type: ResponseListData): ResponseListViewData {
        return ResponseListViewData(
            items = parseResultDataToViewData(type.results)
        )
    }

    private fun parseResultDataToViewData(results: List<ResultsData>?): List<ResultItemViewData> {
        return results.orEmpty().map {
            ResultItemViewData(
                id = it.id.orEmpty(),
                imageUrl = it.thumbnail.orEmpty(),
                productName = it.title.orEmpty(),
                price = it.price?.roundToInt() ?: 0
            )
        }
    }
}
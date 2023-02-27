package com.example.melimarketplace.domain.mapper

import com.example.melimarketplace.data.model.detail.ResponseDetailData
import com.example.melimarketplace.data.model.list.ResponseListData
import com.example.melimarketplace.ui.model.DetailViewData
import com.example.melimarketplace.ui.model.ResponseListViewData

interface MarketPlaceMapperFacade {
    fun marketPlaceListExecuteMapper(responseListData: ResponseListData): ResponseListViewData
    fun marketPlaceDetailExecuteMapper(resultsData: List<ResponseDetailData>): DetailViewData
}
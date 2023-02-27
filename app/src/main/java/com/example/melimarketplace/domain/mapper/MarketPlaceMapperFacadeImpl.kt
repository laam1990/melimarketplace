package com.example.melimarketplace.domain.mapper

import com.example.melimarketplace.data.model.detail.ResponseDetailData
import com.example.melimarketplace.data.model.list.ResponseListData
import com.example.melimarketplace.ui.model.DetailViewData
import com.example.melimarketplace.ui.model.ResponseListViewData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MarketPlaceMapperFacadeImpl @Inject constructor(
    private val marketPlaceListItemsMapper: MarketPlaceListItemsMapper,
    private val marketPlaceDetailMapper: MarketPlaceDetailMapper
) : MarketPlaceMapperFacade {
    override fun marketPlaceListExecuteMapper(responseListData: ResponseListData):
        ResponseListViewData = marketPlaceListItemsMapper.executeMapping(responseListData)

    override fun marketPlaceDetailExecuteMapper(resultsData: List<ResponseDetailData>):
        DetailViewData = marketPlaceDetailMapper.executeMapping(resultsData)
}
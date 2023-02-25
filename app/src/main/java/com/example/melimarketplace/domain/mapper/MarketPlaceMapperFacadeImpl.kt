package com.example.melimarketplace.domain.mapper

import com.example.melimarketplace.data.model.list.ResponseListData
import com.example.melimarketplace.ui.model.ResponseListViewData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MarketPlaceMapperFacadeImpl @Inject constructor(
    private val marketPlaceListItemsMapper: MarketPlaceListItemsMapper
    //private val marketPlaceDetailMapper: MarketPlaceDetailMapper
) : MarketPlaceMapperFacade {
    override fun marketPlaceListExecuteMapper(responseListData: ResponseListData): ResponseListViewData =
        marketPlaceListItemsMapper.executeMapping(responseListData)

    /*override fun marketPlaceDetailExecuteMapper(mainResponseDetailData: List<MainResponseDetailData>): MarketPlaceDetailViewData =
        marketPlaceDetailMapper.executeMapping(mainResponseDetailData)*/
}
package com.example.melimarketplace.domain.repository

import androidx.paging.PagingData
import com.example.melimarketplace.data.util.Resource
import com.example.melimarketplace.ui.model.DetailViewData
import com.example.melimarketplace.ui.model.ResultItemViewData
import kotlinx.coroutines.flow.Flow

interface MarketPlaceRepository {
    fun getListItems(query: String): Flow<PagingData<ResultItemViewData>>
    fun getDetail(id: String): Flow<Resource<DetailViewData>>
}
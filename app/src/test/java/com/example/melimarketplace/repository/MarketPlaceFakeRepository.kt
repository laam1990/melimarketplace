package com.example.melimarketplace.repository

import androidx.paging.PagingData
import com.example.melimarketplace.data.util.Resource
import com.example.melimarketplace.domain.repository.MarketPlaceRepository
import com.example.melimarketplace.ui.model.DetailViewData
import com.example.melimarketplace.ui.model.ResultItemViewData
import io.mockk.mockk
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

open class MarketPlaceFakeRepository : MarketPlaceRepository {

    private var willReturnError = false

    fun setWillReturnError(value: Boolean) {
        willReturnError = value
    }

    override fun getListItems(query: String): Flow<PagingData<ResultItemViewData>> =
        flow {
            val item: List<ResultItemViewData> = mockk(relaxed = true)
        }

    override fun getDetail(id: String): Flow<Resource<DetailViewData>> =
        flow {
            val marketPlaceDetailViewData: DetailViewData = mockk(relaxed = true)
            emit(Resource.Loading())
            if (willReturnError) {
                emit(Resource.Error(Throwable()))
            } else {
                emit(Resource.Success(marketPlaceDetailViewData))
            }
        }
}
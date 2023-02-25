package com.example.melimarketplace.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import com.example.melimarketplace.data.api.RemoteDataSource
import com.example.melimarketplace.data.paging.PagingSource
import com.example.melimarketplace.data.util.getDefaultPagingConfig
import com.example.melimarketplace.domain.mapper.MarketPlaceMapperFacade
import com.example.melimarketplace.ui.model.ResultItemViewData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MarketPlaceRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val marketPlaceMapperFacade: MarketPlaceMapperFacade
) : MarketPlaceRepository {

    override fun getListItems(query: String): Flow<PagingData<ResultItemViewData>> =
        Pager(
            config = getDefaultPagingConfig(),
            pagingSourceFactory = {
                PagingSource(remoteDataSource, marketPlaceMapperFacade, query)
            }
        ).flow
}
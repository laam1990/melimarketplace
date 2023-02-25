package com.example.melimarketplace.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.melimarketplace.data.api.RemoteDataSource
import com.example.melimarketplace.data.util.DataConstant.LIMIT
import com.example.melimarketplace.data.util.DataConstant.PAGE_INDEX_INITIAL
import com.example.melimarketplace.domain.mapper.MarketPlaceMapperFacade
import com.example.melimarketplace.ui.model.ResultItemViewData
import retrofit2.HttpException
import java.io.IOException

class PagingSource(
    private val remoteDataSource: RemoteDataSource,
    private val marketPlaceMapperFacade: MarketPlaceMapperFacade,
    private val query: String
) : PagingSource<Int, ResultItemViewData>() {
    override fun getRefreshKey(state: PagingState<Int, ResultItemViewData>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultItemViewData> {
        val position = params.key ?: PAGE_INDEX_INITIAL

        return try {
            val networkRequest = remoteDataSource.getListItemsBySearch(query, position, LIMIT)
            val marketPlaceList =
                marketPlaceMapperFacade.marketPlaceListExecuteMapper(networkRequest)
            LoadResult.Page(
                data = marketPlaceList.items,
                prevKey = if (position == PAGE_INDEX_INITIAL) null else position - 1,
                nextKey = if (marketPlaceList.items.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}
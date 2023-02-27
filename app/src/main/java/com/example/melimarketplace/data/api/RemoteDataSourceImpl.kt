package com.example.melimarketplace.data.api

import com.example.melimarketplace.data.model.detail.ResponseDetailData
import com.example.melimarketplace.data.model.list.ResponseListData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) : RemoteDataSource {

    override suspend fun getListItemsBySearch(query: String, offset: Int, limit: Int):
        ResponseListData = apiService.getListItemsBySearch(query, offset, limit)

    override suspend fun getDetailById(ids: String): List<ResponseDetailData> =
        apiService.getDetailById(ids)
}
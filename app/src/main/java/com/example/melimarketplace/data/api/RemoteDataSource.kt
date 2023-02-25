package com.example.melimarketplace.data.api

import com.example.melimarketplace.data.model.list.ResponseListData
import retrofit2.http.Query

interface RemoteDataSource {

    suspend fun getListItemsBySearch(
        @Query("q") query: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): ResponseListData

    /*suspend fun getDetailById(
        @Query("ids") ids: String
    ): List<>*/

}
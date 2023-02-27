package com.example.melimarketplace.data.api

import com.example.melimarketplace.data.model.detail.ResponseDetailData
import com.example.melimarketplace.data.model.list.ResponseListData
import com.example.melimarketplace.data.util.DataConstant.GET_DETAIL_BY_ID
import com.example.melimarketplace.data.util.DataConstant.GET_LIST_ITEMS_BY_QUERY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    /**
     * List item by search
     * https://api.mercadolibre.com/sites/{SITE_ID}/search?q=Motorola%20G6&offset=0&limit=15
     */

    @GET(GET_LIST_ITEMS_BY_QUERY)
    suspend fun getListItemsBySearch(
        @Query("q") query: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): ResponseListData

    /**
     * Multiget items detail.
     * https://api.mercadolibre.com/items?ids=MLA1318177291
     */
    @GET(GET_DETAIL_BY_ID)
    suspend fun getDetailById(
        @Query("ids") ids: String
    ): List<ResponseDetailData>

}
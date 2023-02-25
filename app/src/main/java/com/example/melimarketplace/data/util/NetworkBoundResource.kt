package com.example.melimarketplace.data.util

import android.util.Log
import kotlinx.coroutines.flow.*

const val TAG = "NetworkBoundResource"

inline fun <RequestType> networkResource(
    crossinline networkCall: suspend () -> RequestType,
) = flow {
    emit(Resource.Loading())
    emit(Resource.Success(networkCall()))
}.catch { throwable ->
    Log.w(TAG, "networkResource: Resource.Error", throwable)
    emit(Resource.Error())
}

inline fun <ResultType, RequestType> networkResourceWithMapper(
    crossinline networkCall: suspend () -> RequestType,
    crossinline mapperResponse: (RequestType) -> ResultType
) = flow {
    emit(Resource.Loading())
    emit(Resource.Success(mapperResponse(networkCall())))
}.catch { throwable ->
    Log.w(TAG, "networkResource: Resource.Error", throwable)
    emit(Resource.Error())
}
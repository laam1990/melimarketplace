package com.example.melimarketplace.data.util

sealed class Resource<T>(val data: T? = null) {
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(data: T? = null) : Resource<T>(data)
}

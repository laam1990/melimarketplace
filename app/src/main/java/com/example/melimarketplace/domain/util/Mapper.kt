package com.example.melimarketplace.domain.util

interface Mapper<Output, Input> {
    fun executeMapping(type: Input): Output
}
package com.example.melimarketplace.di

import com.example.melimarketplace.domain.mapper.MarketPlaceListItemsMapper
import com.example.melimarketplace.domain.mapper.MarketPlaceMapperFacade
import com.example.melimarketplace.domain.mapper.MarketPlaceMapperFacadeImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    @Singleton
    fun provideListItemsMapperFacadeImpl(
        mealMapper: MarketPlaceListItemsMapper
    ) = MarketPlaceMapperFacadeImpl(
        mealMapper
    ) as MarketPlaceMapperFacade
}

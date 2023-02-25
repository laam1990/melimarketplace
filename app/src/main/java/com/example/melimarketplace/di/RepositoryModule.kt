package com.example.melimarketplace.di

import com.example.melimarketplace.data.api.RemoteDataSource
import com.example.melimarketplace.domain.mapper.MarketPlaceMapperFacade
import com.example.melimarketplace.domain.repository.MarketPlaceRepository
import com.example.melimarketplace.domain.repository.MarketPlaceRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMealRepositoryImpl(
        remoteDataSource: RemoteDataSource,
        mapperFacade: MarketPlaceMapperFacade
    ) = MarketPlaceRepositoryImpl(
        remoteDataSource,
        mapperFacade
    ) as MarketPlaceRepository

}
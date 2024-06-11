package com.example.lampshop_kotlin.core.di

import com.example.lampshop_kotlin.data.network.LampService
import com.example.lampshop_kotlin.data.repository.LampRepositoryImpl
import com.example.lampshop_kotlin.domain.repository.LampRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindHereRepository(
        lampRepositoryImpl: LampRepositoryImpl
    ): LampRepository
}
package com.fots.jetsport.di

import com.fots.jetsport.data.repository.HomeRepository
import com.fots.jetsport.data.repository.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * @author: fevziomurtekin
 * @date: 22/04/2021
 */

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository


}
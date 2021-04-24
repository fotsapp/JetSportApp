package com.fots.jetsport.di

import com.fots.jetsport.data.mapper.HomeMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author: fevziomurtekin
 * @date: 24/04/2021
 */

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    fun provideHomeMapper() = HomeMapper()
}
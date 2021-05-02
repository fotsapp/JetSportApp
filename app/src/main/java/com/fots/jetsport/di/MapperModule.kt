package com.fots.jetsport.di

import com.fots.jetsport.core.JetSportMapper
import com.fots.jetsport.data.local.entities.FootballMatchEntity
import com.fots.jetsport.data.mapper.HomeMapper
import com.fots.jetsport.data.remote.FootballMatch
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

/**
 * @author: fevziomurtekin
 * @date: 24/04/2021
 */

@Module
@InstallIn(ViewModelComponent::class)
object MapperModule {

    @Provides
    fun provideHomeMapper(): JetSportMapper<FootballMatchEntity, FootballMatch> = HomeMapper()
}
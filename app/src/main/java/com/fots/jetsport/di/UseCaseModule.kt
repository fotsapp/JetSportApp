package com.fots.jetsport.di

import com.fots.jetsport.data.local.JetSportDao
import com.fots.jetsport.data.mapper.HomeMapper
import com.fots.jetsport.data.service.JetSportService
import com.fots.jetsport.home.HomeUseCase
import com.fots.jetsport.home.HomeUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author: fevziomurtekin
 * @date: 24/04/2021
 */

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun providesHomeUseCase(
       service: JetSportService,
       local: JetSportDao,
       mapper: HomeMapper,
       @IODispatcher ioDispatcher: CoroutineDispatcher
    ):HomeUseCase = HomeUseCaseImpl(
        service,
        local,
        mapper,
        ioDispatcher
    )

}
package com.fots.jetsport.di

import com.fots.jetsport.data.repository.HomeUseCase
import com.fots.jetsport.data.repository.HomeUseCaseImpl
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
abstract class UseCaseModule {

    @Binds
    abstract fun bindHomeUseCase(
        homeUseCaseImpl: HomeUseCaseImpl
    ): HomeUseCase


}
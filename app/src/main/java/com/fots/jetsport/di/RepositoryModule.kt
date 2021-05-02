package com.fots.jetsport.di

import com.fots.jetsport.data.repository.HomeUseCase
import com.fots.jetsport.data.repository.HomeUseCaseImpl
import com.fots.jetsport.home.HomeRepository
import com.fots.jetsport.home.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * @author: yusuf.onder
 * @date: 1.05.2021
 */

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository


}
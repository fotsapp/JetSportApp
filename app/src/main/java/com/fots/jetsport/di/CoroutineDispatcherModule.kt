package com.fots.jetsport.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

/**
 * @author: fevziomurtekin
 * @date: 22/04/2021
 */

@Module
@InstallIn(ViewModelComponent::class)
object CoroutineDispatcherModule {

    @DefaultDispatcher
    @Provides
    internal fun provideDefaultDispatcher(): CoroutineDispatcher
            = Dispatchers.Default

    @IODispatcher
    @Provides
    internal fun provideIODispatcher(): CoroutineDispatcher
            = Dispatchers.IO

    @MainDispatcher
    @Provides
    internal fun provideMainDispatcher(): CoroutineDispatcher
            = Dispatchers.Main

}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DefaultDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IODispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainDispatcher
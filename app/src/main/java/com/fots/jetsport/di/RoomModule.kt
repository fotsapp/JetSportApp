package com.fots.jetsport.di

import android.app.Application
import androidx.room.Room
import com.fots.jetsport.BuildConfig
import com.fots.jetsport.data.local.JetSportDatabase
import com.fots.jetsport.data.local.JetSportConverter
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author: fevziomurtekin
 * @date: 22/04/2021
 */

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi
            = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideRoomConverter(moshi: Moshi): JetSportConverter
            = JetSportConverter(moshi)

    @Provides
    @Singleton
    fun providesDeezerDatabase(application: Application)
            = Room.databaseBuilder(application, JetSportDatabase::class.java, BuildConfig.DatabaseName)
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun providesDeezerDao(deezerDatabase: JetSportDatabase)
            = deezerDatabase.jetSportDao()
}

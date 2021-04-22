package com.fots.jetsport.di

import com.fots.jetsport.BuildConfig
import com.fots.jetsport.core.JetSportInterceptor
import com.fots.jetsport.data.service.JetSportService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * @author: fevziomurtekin
 * @date: 22/04/2021
 */


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient():OkHttpClient
            = OkHttpClient.Builder()
        .addInterceptor(JetSportInterceptor())
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BuildConfig.BaseUrl)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder()
                    .addLast(KotlinJsonAdapterFactory())
                    .build()))
        .build()

    @Provides
    @Singleton
    fun provideJetSportService(retrofit: Retrofit) = retrofit.create(JetSportService::class.java)

}

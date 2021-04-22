package com.fots.jetsport.core

import com.fots.jetsport.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author: fevziomurtekin
 * @date: 23/04/2021
 */

const val API_KEY = "x-rapidapi-key"

class JetSportInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(API_KEY, BuildConfig.ApiKey)
            .build()
        return chain.proceed(request)
    }

}
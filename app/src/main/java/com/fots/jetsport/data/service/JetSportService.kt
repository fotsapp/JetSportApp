package com.fots.jetsport.data.service

import com.fots.jetsport.data.remote.FootballMatch
import retrofit2.Response
import retrofit2.http.GET

/**
 * @author: fevziomurtekin
 * @date: 22/04/2021
 */

interface JetSportService{

    @GET(Endpoints.FOOTBALL_LIVE)
    suspend fun getFootballLiveScores():
            Response<List<FootballMatch>>

}

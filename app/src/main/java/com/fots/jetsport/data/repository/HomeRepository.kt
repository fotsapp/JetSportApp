package com.fots.jetsport.data.repository

import com.fots.jetsport.data.Result
import com.fots.jetsport.data.remote.FootballMatch
import com.fots.jetsport.home.HomeUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author: fevziomurtekin
 * @date: 24/04/2021
 */

interface HomeRepository  {
    suspend fun getLiveFootballMatches(): Flow<Result<List<FootballMatch>>>
}

class HomeRepositoryImpl @Inject constructor(
    private val useCase: HomeUseCase
): HomeRepository{
    override suspend fun getLiveFootballMatches(): Flow<Result<List<FootballMatch>>> {
        return useCase.getLiveFootballMatches()
    }
}
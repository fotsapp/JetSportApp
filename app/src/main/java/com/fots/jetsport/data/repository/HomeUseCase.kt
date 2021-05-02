package com.fots.jetsport.data.repository

import com.fots.jetsport.data.Result
import com.fots.jetsport.data.remote.FootballMatch
import com.fots.jetsport.home.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author: fevziomurtekin
 * @date: 24/04/2021
 */

interface HomeUseCase  {
    suspend fun getLiveFootballMatches(): Flow<Result<List<FootballMatch>>>
}

class HomeUseCaseImpl @Inject constructor(
    private val repository: HomeRepository
): HomeUseCase{
    override suspend fun getLiveFootballMatches(): Flow<Result<List<FootballMatch>>> {
        return repository.getLiveFootballMatches()
    }
}
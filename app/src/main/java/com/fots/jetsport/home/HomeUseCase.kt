package com.fots.jetsport.home

import com.fots.jetsport.data.remote.FootballMatch
import com.fots.jetsport.data.service.JetSportService
import com.fots.jetsport.di.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.fots.jetsport.data.Result
import com.fots.jetsport.data.local.JetSportDao
import com.fots.jetsport.data.mapper.HomeMapper
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

/**
 * @author: fevziomurtekin
 * @date: 24/04/2021
 */
interface HomeUseCase {
    suspend fun getLiveFootballMatches(): Flow<Result<List<FootballMatch>>>
}

class HomeUseCaseImpl @Inject constructor(
    private val service: JetSportService,
    private val local: JetSportDao,
    private val mapper: HomeMapper,
    @IODispatcher private val dispatcher: CoroutineDispatcher
): HomeUseCase {
    override suspend fun getLiveFootballMatches(): Flow<Result<List<FootballMatch>>> = flow {
        emit(Result.Loading)
        emit(Result.Success(local.getAllFootballMatches().map { mapper.invoke(it) }))
        service.getFootballLiveScores().let { response ->
            emit(Result.Success(response))
            local.insertMatches(response.map { mapper.invoke(it,true) })
        }
    }.catch { error ->
        emit(Result.Error(error))
    }.flowOn(dispatcher)
}
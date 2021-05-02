package com.fots.jetsport.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fots.jetsport.data.remote.FootballMatch
import com.fots.jetsport.data.repository.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author: fevziomurtekin
 * @date: 24/04/2021
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : ViewModel() {
    private val _liveFootballMatches: MutableStateFlow<LiveFootballMatchUiState> =
        MutableStateFlow(LiveFootballMatchUiState.Loading)
    val liveFootballMatches: StateFlow<LiveFootballMatchUiState> get() = _liveFootballMatches

    init {
        getLiveFootballMatches()
    }

    private fun getLiveFootballMatches() {
        viewModelScope.launch {
            homeUseCase.getLiveFootballMatches().collect { result ->
                result.onSuccess { footballMatches ->
                    _liveFootballMatches.value = LiveFootballMatchUiState.Success(footballMatches)
                }.onError { error ->
                    _liveFootballMatches.value = LiveFootballMatchUiState.Error(error)
                }
            }

        }
    }
}

sealed class LiveFootballMatchUiState {
    data class Success(val matches: List<FootballMatch>) : LiveFootballMatchUiState()
    data class Error(val exception: Throwable) : LiveFootballMatchUiState()
    object Loading : LiveFootballMatchUiState()
}

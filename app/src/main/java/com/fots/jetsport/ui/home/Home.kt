package com.fots.jetsport.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavController
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.fots.jetsport.ui.common.ErrorView
import com.fots.jetsport.ui.common.LoadingView
/**
 * @author: yusuf.onder
 * @date: 24.04.2021
 */

@Composable
fun Home(navController: NavController){
    val viewModel = hiltNavGraphViewModel<HomeViewModel>()
    val liveFootballMatchesState by viewModel.liveFootballMatches.collectAsState()

    when (liveFootballMatchesState) {
        is LiveFootballMatchUiState.Loading -> {
            LoadingView()
        }

        is LiveFootballMatchUiState.Success -> {
            LazyColumn {
                item {
                    (liveFootballMatchesState as? LiveFootballMatchUiState.Success)?.matches?.forEach { footballMatch ->
                        HomeRowView(footballMatch = footballMatch)
                    }
                }
            }
        }

        is LiveFootballMatchUiState.Error -> {
            ErrorView(
                errorMessage =
                (liveFootballMatchesState as LiveFootballMatchUiState.Error)
                    .exception.localizedMessage.orEmpty()
            )
        }

    }
}
package com.fots.jetsport.home

import androidx.lifecycle.ViewModel
import com.fots.jetsport.data.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author: fevziomurtekin
 * @date: 24/04/2021
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
): ViewModel() {

}
package com.fots.jetsport.ui.main

import androidx.annotation.StringRes
import com.fots.jetsport.R
/**
 * @author: yusuf.onder
 * @date: 24.04.2021
 */

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Home : Screen(Route.HOME, R.string.screen_home)
}

object Route {
    const val HOME = "home"
}
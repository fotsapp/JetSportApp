package com.fots.jetsport.data.local

import androidx.room.ProvidedTypeConverter
import com.squareup.moshi.Moshi
import javax.inject.Inject

/**
 * @author: fevziomurtekin
 * @date: 23/04/2021
 */

@ProvidedTypeConverter
class JetSportConverter @Inject constructor(
    val moshi: Moshi
) {



}

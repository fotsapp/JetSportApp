package com.fots.jetsport.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fots.jetsport.data.local.entities.FootballMatchEntity

/**
 * @author: fevziomurtekin
 * @date: 23/04/2021
 */

@Dao
interface JetSportDao {

    @Query("SELECT * FROM FootballMatchEntity")
    suspend fun getAllFootballMatches(): List<FootballMatchEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatches(matches: List<FootballMatchEntity>)
}
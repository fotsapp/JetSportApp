package com.fots.jetsport.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fots.jetsport.data.remote.FootballEventAction
import com.fots.jetsport.data.remote.FootballStadium
import com.fots.jetsport.data.remote.FootballTeam
import com.fots.jetsport.data.remote.FootballTournament
import com.squareup.moshi.Json
import kotlin.random.Random

/**
 * @author: fevziomurtekin
 * @date: 23/04/2021
 */

@Entity(tableName = "footballMatchEntity")
data class FootballMatchEntity(
    @PrimaryKey val entityId: Int,
    @field:ColumnInfo(name = "match_id") val match_id: String,
    @field:ColumnInfo(name= "event_name") val event_name: String,
    @field:ColumnInfo(name= "season") val season: String,
    @field:ColumnInfo(name= "start_time") val start_time: String,
    @field:ColumnInfo(name= "result") val result: List<String>,
    @field:ColumnInfo(name= "date") val date: String,
    @field:ColumnInfo(name= "tournament_type") val tournament_type: String,
    @field:ColumnInfo(name= "visitant_team") val visitant_team: FootballTeam?,
    @field:ColumnInfo(name= "home_team") val home_team: FootballTeam?,
    @field:ColumnInfo(name= "tournament_name") val tournament_name: FootballTournament?,
    @field:ColumnInfo(name= "event_outcome_type") val event_outcome_type: String,
    @field:ColumnInfo(name= "stadium") val stadium: FootballStadium?,
    @field:ColumnInfo(name= "minutes_elapsed") val minutes_elapsed: Int,
)
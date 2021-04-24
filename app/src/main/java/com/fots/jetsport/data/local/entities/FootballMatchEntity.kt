package com.fots.jetsport.data.local.entities

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

@Entity
data class FootballMatchEntity(
    @PrimaryKey(autoGenerate = true)
    val entityId: Int = Random.nextInt(),
    @field:Json(name= "match_id") val match_id: String,
    @field:Json(name= "event_name") val event_name: String,
    @field:Json(name= "season") val season: String,
    @field:Json(name= "start_time") val start_time: String,
    @field:Json(name= "result") val result: List<String>,
    @field:Json(name= "date") val date: String,
    @field:Json(name= "tournament_type") val tournament_type: String,
    @field:Json(name= "visitant_team") val visitant_team: FootballTeam,
    @field:Json(name= "home_team") val home_team: FootballTeam,
    @field:Json(name= "tournament_name") val tournament_name: FootballTournament,
    @field:Json(name= "event_outcome_type") val event_outcome_type: String,
    @field:Json(name= "event_outcome_type") val stadium: FootballStadium,
    @field:Json(name= "minutes_elapsed") val minutes_elapsed: Int,
)
package com.fots.jetsport.data.remote

import com.squareup.moshi.Json

/**
 * @author: fevziomurtekin
 * @date: 23/04/2021
 */

data class FootballMatch(
    @field:Json(name= "match_id") val match_id: String?,
    @field:Json(name= "event_name") val event_name: String?,
    @field:Json(name= "season") val season: String?,
    @field:Json(name= "start_time") val start_time: String?,
    @field:Json(name= "result") val result: List<String>,
    @field:Json(name= "date") val date: String?,
    @field:Json(name= "date") val tournament_type: String?,
    @field:Json(name= "visitant_team") val visitant_team: FootballTeam?,
    @field:Json(name= "home_team") val home_team: FootballTeam?,
    @field:Json(name= "tournament_name") val tournament_name: FootballTournament?,
    @field:Json(name= "event_outcome_type") val event_outcome_type: String?,
    @field:Json(name= "event_outcome_type") val stadium: FootballStadium?,
    @field:Json(name= "minutes_elapsed") val minutes_elapsed: Int?,
    @field:Json(name= "minutes_elevent_status_noteapsed") val event_status_note: String?,
    @field:Json(name= "event_actions") val event_actions: List<FootballEventAction>?,
)

data class FootballTeam(
    @field:Json(name= "image") val image: String?,
    @field:Json(name= "stats") val stats: FootballStats?,
    @field:Json(name= "full") val full: String?,
    @field:Json(name= "first") val first: String?,
    @field:Json(name= "assitant") val assitant: List<String>?
)

data class FootballStats(
    @field:Json(name= "score") val score: String?,
    @field:Json(name= "score_opposing") val score_opposing: String?
)

data class FootballTournament(
    @field:Json(name= "code-name") val codeName: String?,
    @field:Json(name= "code-key") val codeKey: String?,
    @field:Json(name= "code-type") val codeType: String?
)

data class FootballStadium(
    @field:Json(name= "full") val full: String?
)

data class FootballEventAction(
    @field:Json(name= "action") val action: String?,
    @field:Json(name= "minutes_elapsed") val minutes_elapsed: Int?,
    @field:Json(name= "period") val period: String?,
    @field:Json(name= "score_type") val score_type: String?,
    @field:Json(name= "team") val team: String?,
    @field:Json(name= "player") val player: FootballPlayer?,
)

data class FootballPlayer(
    @field:Json(name= "name") val name: String?,
    @field:Json(name= "role") val role: String?
)

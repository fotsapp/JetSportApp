package com.fots.jetsport.data.mapper

import com.fots.jetsport.core.JetSportMapper
import com.fots.jetsport.data.local.entities.FootballMatchEntity
import com.fots.jetsport.data.remote.*
import com.fots.jetsport.extensions.orZero
import javax.inject.Inject

/**
 * @author: fevziomurtekin
 * @date: 24/04/2021
 */
class HomeMapper @Inject constructor():
    JetSportMapper<FootballMatchEntity, FootballMatch> {

    override suspend fun invoke(input: FootballMatchEntity): FootballMatch {
        return FootballMatch(
            match_id = input.match_id,
            event_name = input.event_name,
            season = input.season,
            start_time = input.start_time,
            result = input.result,
            date = input.date,
            tournament_type = input.tournament_type ,
            tournament_name = input.tournament_name,
            home_team = input.home_team,
            visitant_team = input.visitant_team,
            event_outcome_type = input.event_outcome_type,
            stadium = input.stadium,
            minutes_elapsed = input.minutes_elapsed,
            event_status_note = "",
            event_actions = null
        )
    }

    override suspend fun invoke(input: FootballMatch, isEntity: Boolean): FootballMatchEntity {
        return FootballMatchEntity(
            match_id = input.match_id.orEmpty(),
            event_name = input.event_name.orEmpty(),
            season = input.season.orEmpty(),
            start_time = input.start_time.orEmpty(),
            result = input.result,
            date = input.date.orEmpty(),
            tournament_type = input.tournament_type.orEmpty(),
            tournament_name = input.tournament_name
                ?: FootballTournament("","",""),
            home_team = input.home_team
                ?: FootballTeam("", FootballStats("",""),"","", emptyList()),
            visitant_team = input.visitant_team
                ?: FootballTeam("", FootballStats("",""),"","", emptyList()),
            event_outcome_type = input.event_outcome_type.orEmpty(),
            stadium = input.stadium ?: FootballStadium(""),
            minutes_elapsed = input.minutes_elapsed.orZero(),
        )
    }

}
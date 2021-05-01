package com.fots.jetsport.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.fots.jetsport.data.remote.FootballStadium
import com.fots.jetsport.data.remote.FootballTeam
import com.fots.jetsport.data.remote.FootballTournament
import com.squareup.moshi.Moshi
import javax.inject.Inject

/**
 * @author: fevziomurtekin
 * @date: 23/04/2021
 */

@ProvidedTypeConverter
class JetSportConverter @Inject constructor(
    private val moshi: Moshi
) {

    // FootballTeam
    @TypeConverter
    fun fromStringToFootballTeam(value: String): FootballTeam? {
        return moshi.adapter(FootballTeam::class.java).fromJson(value)
    }

    @TypeConverter
    fun fromFootballTeamToString(value: FootballTeam): String? {
        return moshi.adapter(FootballTeam::class.java).toJson(value)
    }

    // FootballTournament
    @TypeConverter
    fun fromStringToFootballTournament(value: String): FootballTournament? {
        return moshi.adapter(FootballTournament::class.java).fromJson(value)
    }

    @TypeConverter
    fun fromFootballTournamentToString(value: FootballTournament): String? {
        return moshi.adapter(FootballTournament::class.java).toJson(value)
    }


    // FootballStadium
    @TypeConverter
    fun fromStringToFootballStadium(value: String): FootballStadium? {
        return moshi.adapter(FootballStadium::class.java).fromJson(value)
    }

    @TypeConverter
    fun fromFootballStadiumToString(value: FootballStadium): String? {
        return moshi.adapter(FootballStadium::class.java).toJson(value)
    }

    // Result
    @TypeConverter
    fun fromStringToResult(value: String): List<String> {
        return value.split(",").toMutableList()
    }

    @TypeConverter
    fun fromResultToString(value: List<String>): String {
        var result = ""
        value.forEach { element ->
            result += "$element,"
        }
        return result.removeSuffix(",")
    }

}

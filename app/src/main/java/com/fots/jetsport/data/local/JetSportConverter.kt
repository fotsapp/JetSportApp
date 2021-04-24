package com.fots.jetsport.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.fots.jetsport.data.local.entities.FootballMatchEntity
import com.fots.jetsport.data.remote.FootballStadium
import com.fots.jetsport.data.remote.FootballTeam
import com.fots.jetsport.data.remote.FootballTournament
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

/**
 * @author: fevziomurtekin
 * @date: 23/04/2021
 */

@ProvidedTypeConverter
class JetSportConverter @Inject constructor(
    private val moshi: Moshi
) {

    // FootballMatchEntity
    @TypeConverter
    fun fromStringToFootballMatchEntity(value: String): FootballMatchEntity?
        = Types.newParameterizedType(String::class.java, FootballMatchEntity::class.java)
        ?.let { type ->
            moshi.adapter<FootballMatchEntity>(type)
                .fromJson(value)
        }

    @TypeConverter
    fun fromFootballMatchEntityToString(value: FootballMatchEntity): String
        =  Types.newParameterizedType(FootballMatchEntity::class.java, String::class.java)
        ?.let { type ->
            moshi.adapter<String>(type)
                .fromJsonValue(value)
        }.orEmpty()


    // FootballTeam
    @TypeConverter
    fun fromStringToFootballTeam(value: String): FootballTeam?
            = Types.newParameterizedType(String::class.java, FootballTeam::class.java)
        ?.let { type ->
            moshi.adapter<FootballTeam>(type)
                .fromJson(value)
        }

    @TypeConverter
    fun fromFootballTeamToString(value: FootballTeam): String
            =  Types.newParameterizedType(FootballTeam::class.java, String::class.java)
        ?.let { type ->
            moshi.adapter<String>(type)
                .fromJsonValue(value)
        }.orEmpty()

    // FootballTournament
    @TypeConverter
    fun fromStringToFootballTournament(value: String): FootballTournament?
            = Types.newParameterizedType(String::class.java, FootballTournament::class.java)
        ?.let { type ->
            moshi.adapter<FootballTournament>(type)
                .fromJson(value)
        }

    @TypeConverter
    fun fromFootballTournamentToString(value: FootballTournament): String
            =  Types.newParameterizedType(FootballTournament::class.java, String::class.java)
        ?.let { type ->
            moshi.adapter<String>(type)
                .fromJsonValue(value)
        }.orEmpty()


    // FootballStadium
    @TypeConverter
    fun fromStringToFootballStadium(value: String): FootballStadium?
            = Types.newParameterizedType(String::class.java, FootballStadium::class.java)
        ?.let { type ->
            moshi.adapter<FootballStadium>(type)
                .fromJson(value)
        }

    @TypeConverter
    fun fromFootballStadiumToString(value: FootballStadium): String
            =  Types.newParameterizedType(FootballStadium::class.java, String::class.java)
        ?.let { type ->
            moshi.adapter<String>(type)
                .fromJsonValue(value)
        }.orEmpty()

    // Result
    @TypeConverter
    fun fromStringToResult(value: String): List<String>?
            = Types.newParameterizedType(String::class.java, Array<String>::class.java)
        ?.let { type ->
            moshi.adapter<List<String>>(type)
                .fromJson(value)
        }

    @TypeConverter
    fun fromResultToString(value: List<String>): String
            =  Types.newParameterizedType(Array<String>::class.java, String::class.java)
        ?.let { type ->
            moshi.adapter<String>(type)
                .fromJsonValue(value)
        }.orEmpty()

}

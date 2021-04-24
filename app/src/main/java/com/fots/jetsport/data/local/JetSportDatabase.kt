package com.fots.jetsport.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fots.jetsport.data.local.entities.FootballMatchEntity

/**
 * @author: fevziomurtekin
 * @date: 23/04/2021
 */

//TODO will be implement auto migration
// https://medium.com/androiddevelopers/room-auto-migrations-d5370b0ca6eb
@Database(entities = [FootballMatchEntity::class], version = 1, exportSchema = false)
@TypeConverters(value = [JetSportConverter::class])
abstract class JetSportDatabase: RoomDatabase() {
    abstract fun jetSportDao(): JetSportDao
}
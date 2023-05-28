package com.tecsup.edu.lab9_room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tecsup.edu.lab9_room.informations.Information
import com.tecsup.edu.lab9_room.informations.InformationDAO

@Database(entities = [Information::class], version = 1)
abstract class InformationDatabase: RoomDatabase() {

    abstract fun informationDAO() : InformationDAO

    companion object {
        private const val DATABASE_NAME = "information_database"

        @Volatile
        private var INSTANCE: InformationDatabase? = null

        fun getInstance(context:Context): InformationDatabase? {
            INSTANCE
                ?: synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        InformationDatabase::class.java,
                        DATABASE_NAME
                    ).build()
                }
            return INSTANCE
        }


    }

}
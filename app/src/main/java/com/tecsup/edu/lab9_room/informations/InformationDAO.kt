package com.tecsup.edu.lab9_room.informations

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface InformationDAO {

    @Insert
    fun insert(information: Information)

    @Update
    fun update(information: Information)

    @Delete
    fun delete(information: Information)

    @Query("SELECT * FROM information_table")
    fun getNota(): LiveData<List<Information>>
}
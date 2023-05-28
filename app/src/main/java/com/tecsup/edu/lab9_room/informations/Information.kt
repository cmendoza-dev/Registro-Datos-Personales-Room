package com.tecsup.edu.lab9_room.informations

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "information_table")
data class Information (

    @ColumnInfo(name="nombres_apellidos")
    var first_last_name: String,

    @ColumnInfo(name = "telefono")
    var phone_number : String,

    @ColumnInfo(name = "correo")
    var email: String,

    @ColumnInfo(name = "direccion")
    var address: String,


){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_nombre")
    var nombre_Id: Int = 0
}
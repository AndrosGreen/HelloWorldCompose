package com.example.helloworldcompose.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User (
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0L,
    var firstName : String,
    var lastName : String,
    var age : Int
)
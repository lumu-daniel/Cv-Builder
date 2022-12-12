package com.ktn.cvbuilder.data.local.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "work_table")
data class WorkTable(
    var workImage:Int,
    var companyName:String,
    var job:String,
    var from: String,
    var to: String,
    var city:String,
    var state:String,
    var desc:String,
    var userID: Int,

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)

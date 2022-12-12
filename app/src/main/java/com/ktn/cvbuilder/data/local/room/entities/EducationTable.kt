package com.ktn.cvbuilder.data.local.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "education_table")
data class EducationTable(
    var collageImage:Int,
    var collegeName:String,
    var major:String,
    var userId:Int,

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
)

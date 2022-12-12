package com.ktn.cvbuilder.data.local.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_table")
data class ContactTable(
    var contactIcn:Int,
    var contactType:String,
    var contactValue:String,
    var user: String,
    var userId:Int,

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)

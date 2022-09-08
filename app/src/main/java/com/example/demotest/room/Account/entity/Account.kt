package com.example.demotest.room.Account.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "accounts",
    indices = [
        Index("accountEmail", unique = true)
    ]
)
class Account(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = false)
    val id: Long,

    @ColumnInfo("accountUser")
    val AccountUser:String ,

    @ColumnInfo("accountPhone")
    val AccountPhone :String ,

    @ColumnInfo("accountEmail")
    val AccountEmail:String,

    @ColumnInfo("accountCode")
    val AccountCode :String,

    @ColumnInfo("suspended")
    val Suspended:Int = 0,

    @ColumnInfo("accountStatus")
    val AccountStatus:Int = 0,

    @ColumnInfo("reg")
    val Reg:Int = 0,

    @ColumnInfo(name ="created_at")
   val created_at :Long = 0L) {
}
package com.example.demotest.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.demotest.room.Account.Dao.AccountsDao
import com.example.demotest.room.Account.entity.Account

@Database(
    version = 1,
    entities = [
        Account::class,
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAccountDao():AccountsDao

    companion object{

        @Volatile
        var INSTANCE : AppDatabase? = null

        operator fun invoke(context : Context) : AppDatabase{
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "store_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
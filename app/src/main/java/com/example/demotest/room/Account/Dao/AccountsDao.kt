package com.example.demotest.room.Account.Dao

import androidx.room.*
import com.example.demotest.room.Account.entity.Account

@Dao
interface AccountsDao {

    @Query("SELECT * FROM accounts")
    suspend fun getAccount():List<Account>

    @Insert(entity = Account::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun createAccount(account :Account)

    @Update(entity = Account::class,OnConflictStrategy.REPLACE)
    suspend fun updateAccount(account: Account)
}
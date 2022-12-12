package com.ktn.cvbuilder.data.local.room.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ktn.cvbuilder.data.local.room.entities.UserTable

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserTable)

    @Delete
    suspend fun deleteUser(user: UserTable)

    @Query("SELECT * FROM user")
    fun observerAllUser(): LiveData<List<UserTable>>
}
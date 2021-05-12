package com.onix.internship.survay.data.local.tables.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UsersDao {

    @Insert
    suspend fun insert(user: User) : Long

    @Query("SELECT * from users WHERE login = :login AND password = :password")
    suspend fun get(login: String, password: String): List<User>

    @Query("SELECT * FROM users ORDER BY userId ASC")
    suspend fun getAllUsers(): List<User>

    @Update
    suspend fun update(user: User)
}
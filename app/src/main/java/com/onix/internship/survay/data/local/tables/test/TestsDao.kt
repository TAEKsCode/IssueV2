package com.onix.internship.survay.data.local.tables.test

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TestsDao {

    @Insert
    suspend fun insert(test: Test)

    @Query("SELECT * FROM tests")
    suspend fun getAllTests(): List<Test>

    @Query("DELETE FROM tests")
    suspend fun clear()
}
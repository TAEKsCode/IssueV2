package com.onix.internship.survay.data.local.tables.result

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ResultDao {

    @Insert
    fun insert(result: Result)

    @Update
    fun update(result: Result)

    @Query("SELECT * FROM results WHERE resultUserId = :userId AND resultTestId = :testId")
    fun getResult(userId: Long, testId: Long): Result?
}
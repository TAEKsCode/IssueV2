package com.onix.internship.survay.data.local.tables.access

import androidx.room.*

@Dao
interface AccessDao {

    @Insert
    suspend fun insert(access: Access)

    @Update
    suspend fun update(access: Access)

    @Query("SELECT * FROM access WHERE accessUserId = :userId AND accessTestId = :testId")
    suspend fun getAccess(userId: Long, testId: Long): Access?
}

package com.onix.internship.survay.data.local.tables.question

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuestionsDao {

    @Insert
    fun insert(question: Question)

    @Update
    fun update(question: Question)

    @Query("SELECT * FROM questions WHERE questionTestId = :testId")
    fun getQuestionsByTest(testId: Long): List<Question>

}
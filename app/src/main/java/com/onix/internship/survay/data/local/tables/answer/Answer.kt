package com.onix.internship.survay.data.local.tables.answer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "answers")
data class Answer(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "answerId")
    var answerId: Long = 0L,
    @ColumnInfo(name = "answerQuestionId")
    var answerQuestionId: Long = 0L,
    @ColumnInfo(name = "score")
    var score: Int = 0,
    @ColumnInfo(name = "text")
    var text: String = ""
)
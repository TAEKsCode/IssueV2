package com.onix.internship.survay.data.local.tables.question

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class Question(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "questionId")
    var questionId: Long = 0L,
    @ColumnInfo(name = "questionTestId")
    var testId: Long = 0L,
    @ColumnInfo(name = "type")
    var type: String = "",
    @ColumnInfo(name = "text")
    var text: String = ""
)
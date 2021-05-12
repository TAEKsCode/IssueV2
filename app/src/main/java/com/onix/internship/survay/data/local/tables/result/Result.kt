package com.onix.internship.survay.data.local.tables.result

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "results")
data class Result(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "resultId")
    var resultId: Long = 0L,
    @ColumnInfo(name = "resultUserId")
    var resultUserId: Long = 0L,
    @ColumnInfo(name = "date")
    var date: Long = Calendar.getInstance().timeInMillis,
    @ColumnInfo(name = "resultTestId")
    var resultTestId: Long = 0L,
    @ColumnInfo(name = "score")
    var score: Int = 0
)
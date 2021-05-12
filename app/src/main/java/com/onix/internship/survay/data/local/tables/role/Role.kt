package com.onix.internship.survay.data.local.tables.role

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "roles")
data class Role(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "roleId")
    var roleId: Long = 0L,
    @ColumnInfo(name = "role")
    var role: Int = 0
)
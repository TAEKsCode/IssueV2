package com.onix.internship.survay.data.local.tables.auth

import androidx.room.Embedded
import androidx.room.Relation
import com.onix.internship.survay.data.local.tables.user.User

data class AuthAndUser(
    @Embedded val auth: Auth,
    @Relation(
        parentColumn = "authUserId",
        entityColumn = "userId"
    )
    val user: User
)

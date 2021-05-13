package com.onix.internship.survay.data.local.tables.user

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.onix.internship.survay.arch.appflow.Roles
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userId")
    var userId: Long = 0L,
    @ColumnInfo(name = "login")
    var login: String = "",
    @ColumnInfo(name = "password")
    var password: String = "",
    @ColumnInfo(name = "firstName")
    var firstName: String = "",
    @ColumnInfo(name = "lastName")
    var lastName: String = "",
    @ColumnInfo(name = "role")
    var role: Int = -1
): Parcelable {
    fun getRoleState(): Roles {
        return when (role) {
            0 -> Roles.ADMIN
            1 -> Roles.MANAGER
            2 -> Roles.USER
            else -> Roles.DEFAULT
        }
    }

    fun getFullName():String{
        return "$firstName $lastName"
    }
}
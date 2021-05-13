package com.onix.internship.survay.ui.roles.admin.userdetails.changepassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onix.internship.survay.data.local.SurvayDatabase
import com.onix.internship.survay.data.local.tables.user.User

class ChangePasswordViewModelFactory(
    private val user: User, private val database: SurvayDatabase
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChangePasswordViewModel::class.java)) {
            return ChangePasswordViewModel(user, database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
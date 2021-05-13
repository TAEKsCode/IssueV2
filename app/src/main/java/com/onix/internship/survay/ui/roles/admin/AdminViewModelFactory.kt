package com.onix.internship.survay.ui.roles.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onix.internship.survay.data.local.SurvayDatabase

class AdminViewModelFactory(
    private val database: SurvayDatabase
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AdminViewModel::class.java)) {
            return AdminViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
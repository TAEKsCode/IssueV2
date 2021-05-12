package com.onix.internship.survay.ui.autorisation.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onix.internship.survay.data.local.SurvayDatabase

class RegistrationViewModelFactory(
    private val database: SurvayDatabase
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegistrationViewModel::class.java)) {
            return RegistrationViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
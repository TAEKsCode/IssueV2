package com.onix.internship.survay.ui.roles.admin.userdetails.changepassword

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.onix.internship.survay.arch.error.states.ErrorStates
import com.onix.internship.survay.arch.lifecycle.SingleLiveEvent
import com.onix.internship.survay.data.local.SurvayDatabase
import com.onix.internship.survay.data.local.tables.user.User
import com.onix.internship.survay.data.security.md5
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChangePasswordViewModel(private val user: User, private val database: SurvayDatabase) :
    ViewModel() {

    private val _shouldDismiss = MutableLiveData(false)
    val shouldDismiss: LiveData<Boolean> = _shouldDismiss

    private val _errorOldPassword = MutableLiveData(ErrorStates.NONE)
    val errorOldPassword: LiveData<ErrorStates> = _errorOldPassword

    private val _errorPassword = MutableLiveData(ErrorStates.NONE)
    val errorPassword: LiveData<ErrorStates> = _errorPassword

    val model = ChangePasswordModel()

    fun onSaveClick() {
        model.apply {
            _errorOldPassword.value = isTwoPasswordsTheSame(md5(oldPassword), user.password)
            _errorPassword.value = isNewPasswordValid()
            if (!isError(user.password)) {
                user.password = md5(confirmedPassword)
                updateUserInDatabase()
            }
        }
    }

    private fun updateUserInDatabase() {
        viewModelScope.launch(Dispatchers.IO) {
            database.userDao.update(user)
            _shouldDismiss.postValue(true)
        }
    }
}
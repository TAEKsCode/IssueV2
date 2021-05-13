package com.onix.internship.survay.ui.roles.admin.userdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.onix.internship.survay.arch.error.states.ErrorStates
import com.onix.internship.survay.arch.lifecycle.SingleLiveEvent
import com.onix.internship.survay.data.local.SurvayDatabase
import com.onix.internship.survay.data.local.tables.user.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserDetailsViewModel(val user: User, private val database: SurvayDatabase) : ViewModel() {

    private val _navigationEvent = SingleLiveEvent<NavDirections>()
    val navigationEvent: LiveData<NavDirections> = _navigationEvent

    private val _errorLogin = MutableLiveData(ErrorStates.NONE)
    val errorLogin: LiveData<ErrorStates> = _errorLogin

    private val _errorPassword = MutableLiveData(ErrorStates.NONE)
    val errorPassword: LiveData<ErrorStates> = _errorPassword

    private val _errorFirstName = MutableLiveData(ErrorStates.NONE)
    val errorFirstName: LiveData<ErrorStates> = _errorFirstName

    private val _errorLastName = MutableLiveData(ErrorStates.NONE)
    val errorLastName: LiveData<ErrorStates> = _errorLastName

    fun onSaveClick() {
        viewModelScope.launch(Dispatchers.IO) {
            database.userDao.update(user)
            _navigationEvent.postValue(UserDetailsFragmentDirections.actionUserDetailsFragmentToAdminFragment())
        }
    }

    fun onChangePasswordClick() {
        _navigationEvent.postValue(
            UserDetailsFragmentDirections.actionUserDetailsFragmentToChangePasswordDialog(
                user
            )
        )
    }

    fun onRoleSelected(roleIndex: Int) {
        user.role = roleIndex
    }

}
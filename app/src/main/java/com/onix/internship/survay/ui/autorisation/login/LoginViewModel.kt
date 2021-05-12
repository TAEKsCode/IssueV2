package com.onix.internship.survay.ui.autorisation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.onix.internship.survay.arch.error.ErrorStates
import com.onix.internship.survay.arch.lifecycle.SingleLiveEvent

class LoginViewModel : ViewModel() {
    val model = LoginModel()

    private val _navigationEvent = SingleLiveEvent<NavDirections>()
    val navigationEvent: LiveData<NavDirections> = _navigationEvent

    private val _errorLogin = MutableLiveData(ErrorStates.NONE)
    val errorLogin: LiveData<ErrorStates> = _errorLogin

    private val _errorPassword = MutableLiveData(ErrorStates.NONE)
    val errorPassword: LiveData<ErrorStates> = _errorPassword

    fun onConnectClick() {
        model.apply {
            _errorLogin.value = isLoginEmpty()
            _errorPassword.value = isPasswordEmpty()
            if (isCorrect()) {
                loginToApp()
            }
        }
    }

    private fun loginToApp() {

    }
}
package com.onix.internship.survay.ui.autorisation.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.onix.internship.survay.arch.error.ErrorStates
import com.onix.internship.survay.arch.lifecycle.SingleLiveEvent

class RegistrationViewModel : ViewModel() {

    val model = RegistrationModel()

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

    fun onSubmitClick() {
        model.apply {
            _errorLogin.value = isLoginCorrect()
            _errorFirstName.value = isFirstNameCorrect()
            _errorLastName.value = isLastNameCorrect()
            _errorPassword.value = isPasswordCorrect()
            if (isCorrect()) {
                registerNewUser()
            }
        }
    }

    private fun registerNewUser() {

    }
}
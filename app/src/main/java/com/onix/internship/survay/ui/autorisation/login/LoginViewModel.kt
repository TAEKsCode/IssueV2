package com.onix.internship.survay.ui.autorisation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.onix.internship.survay.arch.error.states.ErrorStates
import com.onix.internship.survay.arch.lifecycle.SingleLiveEvent
import com.onix.internship.survay.data.local.SurvayDatabase
import com.onix.internship.survay.data.local.tables.auth.Auth
import com.onix.internship.survay.data.security.md5
import com.onix.internship.survay.ui.autorisation.AuthFragmentDirections
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(private val database: SurvayDatabase) : ViewModel() {
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
        viewModelScope.launch(Dispatchers.IO) {
            model.apply {
                val userList = database.userDao.get(login, md5(password))
                if (userList.isNotEmpty()) {
                    database.authDao.insert(
                        Auth(
                            authUserId = userList.first().userId,
                            timeStamp = System.currentTimeMillis()
                        )
                    )
                    _navigationEvent.postValue(AuthFragmentDirections.actionAuthFragmentToAdminFragment())
                } else {
                    _errorPassword.postValue(ErrorStates.NO_SUCH_USER)
                }
            }
        }
    }
}
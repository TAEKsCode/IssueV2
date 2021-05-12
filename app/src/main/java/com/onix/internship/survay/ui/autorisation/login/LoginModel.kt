package com.onix.internship.survay.ui.autorisation.login

import com.onix.internship.survay.arch.error.ErrorStates

data class LoginModel(var login: String = "", var password: String = "") {

    fun isLoginEmpty(): ErrorStates {
        return if (login.isEmpty()) {
            ErrorStates.EMPTY_FIELD
        } else {
            ErrorStates.NONE
        }
    }

    fun isPasswordEmpty(): ErrorStates {
        return if (password.isEmpty()) {
            ErrorStates.EMPTY_FIELD
        } else {
            ErrorStates.NONE
        }
    }

    fun isCorrect(): Boolean{
        return login.isNotEmpty() && password.isNotEmpty()
    }
}

package com.onix.internship.survay.ui.autorisation.register

import com.onix.internship.survay.arch.error.ErrorStates

data class RegistrationModel(
    var firstName: String = "",
    var lastName: String = "",
    var login: String = "",
    var password: String = "",
    var confirmedPassword: String = ""
) {
    fun isFirstNameCorrect(): ErrorStates {
        return if (firstName.isNotEmpty()) {
            ErrorStates.NONE
        } else {
            ErrorStates.EMPTY_FIELD
        }
    }

    fun isLastNameCorrect(): ErrorStates {
        return if (lastName.isNotEmpty()) {
            ErrorStates.NONE
        } else {
            ErrorStates.EMPTY_FIELD
        }
    }

    fun isLoginCorrect(): ErrorStates {
        return if (login.isNotEmpty()) {
            ErrorStates.NONE
        } else {
            ErrorStates.EMPTY_FIELD
        }
    }

    fun isPasswordCorrect(): ErrorStates {
        return when {
            password.isEmpty() -> {
                ErrorStates.EMPTY_FIELD
            }
            password != confirmedPassword -> {
                ErrorStates.PASSWORDS_NOT_THE_SAME
            }
            else -> {
                ErrorStates.NONE
            }
        }
    }

    fun isCorrect(): Boolean {
        return firstName.isNotEmpty() && lastName.isNotEmpty() && login.isNotEmpty()
                && password.isNotEmpty() && password == confirmedPassword
    }
}
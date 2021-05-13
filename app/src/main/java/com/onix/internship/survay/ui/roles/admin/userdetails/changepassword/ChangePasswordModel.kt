package com.onix.internship.survay.ui.roles.admin.userdetails.changepassword

import com.onix.internship.survay.arch.error.states.ErrorStates
import com.onix.internship.survay.data.security.md5

data class ChangePasswordModel(
    var oldPassword: String = "",
    var newPassword: String = "",
    var confirmedPassword: String = ""
) {
    fun isTwoPasswordsTheSame(firstPassword: String, secondPassword: String): ErrorStates {
        return if (firstPassword == secondPassword) {
            ErrorStates.NONE
        } else {
            ErrorStates.PASSWORDS_NOT_THE_SAME
        }
    }

    fun isNewPasswordValid(): ErrorStates {
        return when {
            newPassword.isEmpty() -> {
                ErrorStates.EMPTY_FIELD
            }
            newPassword != confirmedPassword -> {
                ErrorStates.PASSWORDS_NOT_THE_SAME
            }
            else -> {
                ErrorStates.NONE
            }
        }
    }

    fun isError(userPassword: String) =
        userPassword != md5(oldPassword) || newPassword.isEmpty() || confirmedPassword.isEmpty() || newPassword != confirmedPassword
}
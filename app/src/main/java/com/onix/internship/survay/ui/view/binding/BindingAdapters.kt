package com.onix.internship.survay.ui.view.binding

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import com.onix.internship.survay.R
import com.onix.internship.survay.arch.error.ErrorStates

@BindingAdapter("displayError")
fun TextInputLayout.displayError(errorStates: ErrorStates) {
    error = when (errorStates) {
        ErrorStates.NONE -> ""
        ErrorStates.INCORRECT_LOGIN -> context.getString(R.string.incorrect_login)
        ErrorStates.INCORRECT_PASSWORD -> context.getString(R.string.incorrect_password)
        ErrorStates.EMPTY_FIELD -> context.getString(R.string.empty_field)
        ErrorStates.NO_SUCH_USER -> context.getString(R.string.no_such_user)
        ErrorStates.PASSWORDS_NOT_THE_SAME -> context.getString(R.string.passwords_not_the_same)
    }
}

package com.onix.internship.survay.ui.view.binding

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import com.onix.internship.survay.R
import com.onix.internship.survay.arch.appflow.Roles
import com.onix.internship.survay.arch.error.states.ErrorStates

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

@BindingAdapter("setRole")
fun TextView.setRole(roles: Roles) {
    text = when (roles) {
        Roles.ADMIN -> context.getString(R.string.role, context.getString(R.string.admin))
        Roles.MANAGER -> context.getString(R.string.role, context.getString(R.string.manager))
        Roles.USER -> context.getString(R.string.role, context.getString(R.string.user))
        else -> ""
    }
}

@BindingAdapter("setVisibility")
fun ProgressBar.setVisibility(isVisible: Boolean) {
    visibility = when (isVisible) {
        true -> View.VISIBLE
        false -> View.GONE
    }
}
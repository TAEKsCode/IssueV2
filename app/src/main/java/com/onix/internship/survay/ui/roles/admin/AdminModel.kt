package com.onix.internship.survay.ui.roles.admin

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.onix.internship.survay.data.local.tables.user.User

data class AdminModel(
    private var _currentUser: User = User()
) : BaseObservable() {

    @Bindable
    var currentUser = _currentUser
    set(value) {
        field = value
        notifyPropertyChanged(BR.currentUser)
    }

}

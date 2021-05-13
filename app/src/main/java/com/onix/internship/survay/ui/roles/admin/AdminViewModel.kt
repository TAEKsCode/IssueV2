package com.onix.internship.survay.ui.roles.admin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.onix.internship.survay.arch.lifecycle.SingleLiveEvent
import com.onix.internship.survay.data.local.SurvayDatabase
import com.onix.internship.survay.data.local.tables.user.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AdminViewModel(private val database: SurvayDatabase) : ViewModel() {

    val model = AdminModel()

    private val _navigationEvent = SingleLiveEvent<NavDirections>()
    val navigationEvent: LiveData<NavDirections> = _navigationEvent

    private val _isDataLoading = MutableLiveData(true)
    val isDataLoading: LiveData<Boolean> = _isDataLoading

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    init {
        viewModelScope.launch(Dispatchers.IO) {
            model.currentUser = database.authDao.getCurrentUser().user
            _users.postValue(database.userDao.getAllUsers())
            _isDataLoading.postValue(false)
        }
    }

}
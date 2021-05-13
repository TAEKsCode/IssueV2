package com.onix.internship.survay.ui.lists.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.onix.internship.survay.data.local.tables.user.User
import com.onix.internship.survay.databinding.ItemUserBinding

class UserAdapter(private val listener: ((User) -> Unit)? = null) :
    ListAdapter<User, UserViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

}


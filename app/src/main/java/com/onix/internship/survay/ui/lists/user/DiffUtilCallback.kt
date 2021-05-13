package com.onix.internship.survay.ui.lists.user

import androidx.recyclerview.widget.DiffUtil
import com.onix.internship.survay.data.local.tables.user.User


class DiffUtilCallback
    : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(
        oldItem: User,
        newItem: User
    ): Boolean {
        return oldItem.userId == newItem.userId
    }

    override fun areContentsTheSame(
        oldItem: User,
        newItem: User
    ): Boolean {
        return oldItem == newItem
    }
}

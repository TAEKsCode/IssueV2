package com.onix.internship.survay.ui.lists.user

import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.survay.data.local.tables.user.User
import com.onix.internship.survay.databinding.ItemUserBinding


class UserViewHolder(private val binding: ItemUserBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: User, listener: ((User) -> Unit)?) {
        binding.user = item
        binding.userContainer.setOnClickListener { listener?.invoke(item) }
    }
}
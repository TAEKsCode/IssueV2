package com.onix.internship.survay.ui.autorisation

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.onix.internship.survay.ui.autorisation.login.LoginFragment
import com.onix.internship.survay.ui.autorisation.register.RegistrationFragment

class AuthAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LoginFragment()
            else -> RegistrationFragment()
        }
    }
}

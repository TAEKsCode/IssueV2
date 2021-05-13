package com.onix.internship.survay.ui.roles.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.onix.internship.survay.data.local.SurvayDatabase
import com.onix.internship.survay.databinding.FragmentAdminBinding
import com.onix.internship.survay.ui.lists.user.UserAdapter

class AdminFragment : Fragment() {

    private lateinit var binding: FragmentAdminBinding
    private val userAdapter = UserAdapter {
        navigate(AdminFragmentDirections.actionAdminFragmentToUserDetailsFragment(it))
    }

    private val viewModel: AdminViewModel by viewModels {
        AdminViewModelFactory(
            SurvayDatabase.getInstance(
                requireContext()
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdminBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.adminUserList.layoutManager = LinearLayoutManager(requireContext())
        binding.adminUserList.adapter = userAdapter
        binding.adminBack.setOnClickListener { findNavController().popBackStack() }
        viewModel.users.observe(viewLifecycleOwner, { userAdapter.submitList(it) })
        viewModel.navigationEvent.observe(viewLifecycleOwner, ::navigate)
    }

    private fun navigate(direction: NavDirections) {
        findNavController().navigate(direction)
    }
}
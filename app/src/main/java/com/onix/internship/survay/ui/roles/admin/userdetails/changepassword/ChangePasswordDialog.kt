package com.onix.internship.survay.ui.roles.admin.userdetails.changepassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.onix.internship.survay.arch.view.dialog.DialogResizable
import com.onix.internship.survay.data.local.SurvayDatabase
import com.onix.internship.survay.databinding.DialogChangePasswordBinding

class ChangePasswordDialog : DialogFragment(), DialogResizable {

    private val args: ChangePasswordDialogArgs by navArgs()
    private val viewModel: ChangePasswordViewModel by viewModels {
        ChangePasswordViewModelFactory(
            args.user,
            SurvayDatabase.getInstance(requireContext())
        )
    }
    private lateinit var binding: DialogChangePasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogChangePasswordBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDialogSize()
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.shouldDismiss.observe(viewLifecycleOwner, { if (it){ dismiss()} })
    }

    override fun getDialogWidth() = 0.75f

    override fun getDialogHeight() = 0.5f
}
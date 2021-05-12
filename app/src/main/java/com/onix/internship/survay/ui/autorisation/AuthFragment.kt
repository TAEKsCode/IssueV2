package com.onix.internship.survay.ui.autorisation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.MarginPageTransformer
import com.google.android.material.tabs.TabLayoutMediator
import com.onix.internship.survay.R
import com.onix.internship.survay.databinding.FragmentAuthBinding

class AuthFragment : Fragment() {

    private lateinit var binding: FragmentAuthBinding
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.authViewPager.adapter = AuthAdapter(this)
        binding.authViewPager.setPageTransformer(MarginPageTransformer(500))
        binding.authViewPager.offscreenPageLimit = 2
        TabLayoutMediator(binding.authTabLayout, binding.authViewPager) { tab, position ->
            tab.text = requireContext().resources.getStringArray(R.array.auth_headers)[position]
        }.attach()
    }
}

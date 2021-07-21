package com.vogproject.mktfy.ui.passworduis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.vogproject.mktfy.R
import com.vogproject.mktfy.databinding.FragmentChangePasswordBinding
import com.vogproject.mktfy.models.password.PasswordViewModel

class ChangePassword : Fragment() {

    private lateinit var binding: FragmentChangePasswordBinding
    private lateinit var viewModel: PasswordViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_change_password, container, false)
        viewModel = ViewModelProvider(this).get(PasswordViewModel::class.java)
        binding.apply {
            viewModel = this@ChangePassword.viewModel

            backButton.setOnClickListener {
                it.findNavController().navigate(R.id.action_changePassword_to_menuFragment)
            }
        }
        return binding.root
    }
}
package com.vogproject.mktfy.ui.passworduis

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.vogproject.mktfy.R
import com.vogproject.mktfy.databinding.FragmentForgotPasswordBinding
import com.vogproject.mktfy.models.password.PasswordViewModel
import com.vogproject.mktfy.ui.home.HomeActivity
import com.vogproject.mktfy.ui.login.LoginActivity


class ForgotPasswordFragment : Fragment() {

   private lateinit var binding: FragmentForgotPasswordBinding
   private lateinit var forgotpassviewModel: PasswordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_forgot_password, container, false)
        forgotpassviewModel = ViewModelProvider(this).get(PasswordViewModel::class.java)
        binding.apply {
            lifecycleOwner = this@ForgotPasswordFragment
            forgotpassviewModel = this@ForgotPasswordFragment.forgotpassviewModel

            forgotVerifyButton.setOnClickListener {
                activity.let {
                    val intent = Intent(it, LoginActivity::class.java)
                    startActivity(intent)
                }
            }

            backButton.setOnClickListener {
                activity.let {
                    val intent = Intent(it, LoginActivity::class.java)
                    startActivity(intent)
                }
            }

        }
        return binding.root
    }
}
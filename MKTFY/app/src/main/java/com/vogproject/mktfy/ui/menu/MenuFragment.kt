package com.vogproject.mktfy.ui.menu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.vogproject.mktfy.R
import com.vogproject.mktfy.databinding.FragmentMenuBinding
import com.vogproject.mktfy.ui.home.HomeActivity
import com.vogproject.mktfy.ui.login.LoginActivity


class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false)

        binding.apply {
            signOutMenuOption.setOnClickListener {
                activity.let {
                    val intent = Intent(it, LoginActivity::class.java)
                    startActivity(intent)
                }
            }

            changePasswordOption.setOnClickListener {
                it.findNavController().navigate(R.id.action_menuFragment_to_changePassword)
            }
            closeMenuButton.setOnClickListener {
                activity.let {
                    val intent = Intent(it, HomeActivity::class.java)
                    startActivity(intent)
                }
            }
            faqMenuOption.setOnClickListener {
                it.findNavController().navigate(R.id.action_menuFragment_to_FAQ)
            }
            myListingsOption.setOnClickListener {
                
            }
        }
        return binding.root
    }
}
package com.vogproject.mktfy.ui.createuser

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.vogproject.mktfy.R
import com.vogproject.mktfy.databinding.FragmentCreateUserBinding
import com.vogproject.mktfy.general.viewModel
import com.vogproject.mktfy.models.EventType
import com.vogproject.mktfy.models.createuser.CreateUserViewModel
import com.vogproject.mktfy.ui.login.LoginActivity
import com.vogproject.mktfy.ui.passworduis.ChangePassword

class CreateUserFragment : Fragment() {

    private lateinit var binding: FragmentCreateUserBinding
    private val viewModel: CreateUserViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_create_user, container, false)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@CreateUserFragment.viewModel
        }
        viewModel.event.observe(viewLifecycleOwner){
            when(it.getContentIfNotHandled()){
                EventType.NEXT -> {
                    findNavController().navigate(R.id.action_createUserFragment_to_createPassword)
                }
                EventType.BACK -> {
                    activity.let {
                        val intent = Intent(it, LoginActivity::class.java)
                        startActivity(intent)
                    }
                }
                null -> {}
            }
        }
        return binding.root
    }
}
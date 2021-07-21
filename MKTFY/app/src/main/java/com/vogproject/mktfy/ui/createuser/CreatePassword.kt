package com.vogproject.mktfy.ui.createuser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.vogproject.mktfy.R
import com.vogproject.mktfy.databinding.FragmentCreatePasswordBinding
import com.vogproject.mktfy.general.network.authentication.Auth0Account


class CreatePassword : Fragment() {

    private lateinit var binding: FragmentCreatePasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_password, container, false)

//        val auth0Account = Auth0Account(this)

        binding.apply {
            backButton.setOnClickListener {
                it.findNavController().navigate(R.id.action_createPassword_to_createUserFragment)
            }

            createPasswordButton.setOnClickListener {
//                CoroutineScope(Dispatchers.IO).launch {
//                  try {
//                      val user = auth0Account.createUser()
//                  } catch (e: Exception){
//                      e.printStackTrace()
//                  }
//                }
            }

        }
        return binding.root
    }
}
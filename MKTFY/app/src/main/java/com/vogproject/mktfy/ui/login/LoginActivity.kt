package com.vogproject.mktfy.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.vogproject.mktfy.ui.navhost.MainActivity
import com.vogproject.mktfy.R
import com.vogproject.mktfy.databinding.ActivityLoginBinding
import com.vogproject.mktfy.general.network.authentication.Auth0Account
import com.vogproject.mktfy.ui.home.HomeActivity
import com.vogproject.mktfy.ui.navhost.MainActivity3


class LoginActivity : AppCompatActivity() {

    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val auth0Account = Auth0Account(this)
        binding.apply {
            inputPassword.setOnKeyListener { v, keyCode, event ->
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                    Toast.makeText(this@LoginActivity, "DONE!", Toast.LENGTH_SHORT).show()

                    return@setOnKeyListener true
                }
                return@setOnKeyListener false
            }
            loginButton.setOnClickListener {
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
            }

            createAccountButton.setOnClickListener {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            }
            forgotLoginPassword.setOnClickListener {
                val intent = Intent(this@LoginActivity, MainActivity3::class.java)
                startActivity(intent)
            }
        }
    }
}
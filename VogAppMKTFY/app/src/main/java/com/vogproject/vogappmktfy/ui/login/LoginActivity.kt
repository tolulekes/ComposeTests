package com.vogproject.vogappmktfy.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.vogproject.vogappmktfy.R
import com.vogproject.vogappmktfy.databinding.ActivityLoginBinding
import com.vogproject.vogappmktfy.databinding.ActivitySplashBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.apply {
            inputPassword.setOnKeyListener { v, keyCode, event ->
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                    Toast.makeText(this@LoginActivity, "DONE!", Toast.LENGTH_SHORT).show()

                    return@setOnKeyListener true
                }
                return@setOnKeyListener false
            }
        }
    }
}
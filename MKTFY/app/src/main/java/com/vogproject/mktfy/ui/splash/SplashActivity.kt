package com.vogproject.mktfy.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.vogproject.mktfy.R
import com.vogproject.mktfy.databinding.ActivitySplashBinding
import com.vogproject.mktfy.general.makeAnimationBundle
import com.vogproject.mktfy.general.startActivityWithClass
import com.vogproject.mktfy.ui.login.LoginActivity
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        CoroutineScope(Dispatchers.IO).launch {
            delay(2000)
            withContext(Dispatchers.Main) {
                startActivityWithClass <LoginActivity>(options = makeAnimationBundle(
                    binding.backCloud to "cloud_back",
                    binding.midCloud to "cloud_mid",
                    binding.frontCloud to "cloud_front",
                    binding.logo to "logo"
                ))
                finish()
            }
        }
    }
}
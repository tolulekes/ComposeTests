package com.vogproject.mktfy.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.vogproject.mktfy.R
import com.vogproject.mktfy.databinding.ActivityBaseBinding

abstract class BaseActivity(val title: Int): AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_base)
        binding.apply {
            title = this@BaseActivity.title
        }
    }
    fun <T: ViewDataBinding> putContentView(layout: Int): T {
        return DataBindingUtil.inflate(layoutInflater, layout, binding.contentFrame, true)
    }
}
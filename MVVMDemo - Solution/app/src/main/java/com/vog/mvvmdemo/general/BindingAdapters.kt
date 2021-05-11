package com.vog.mvvmdemo.general

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("goneVisibility")
fun View.setGoneVisibility(value: Boolean?) {
    visibility = if (value == true) View.VISIBLE else View.GONE
}
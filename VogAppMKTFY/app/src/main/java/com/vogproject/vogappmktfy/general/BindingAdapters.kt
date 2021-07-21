package com.launchpad.mktfy.general

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

@BindingAdapter("list")
fun <T, VH: RecyclerView.ViewHolder> RecyclerView.list(result: List<T>?) {
    if (result != null) (adapter as ListAdapter<T, VH>?)?.submitList(result)
}

@BindingAdapter("src")
fun ImageView.src(path: String){
    Picasso.get()
        .load(path)
        .into(this)
}

@BindingAdapter("goneVisibility")
fun View.setGoneVisibility(value: Boolean?) {
    visibility = if (value == true) View.VISIBLE else View.GONE
}
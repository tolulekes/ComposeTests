package com.vogproject.mktfy.general

import android.content.res.ColorStateList
import android.graphics.Color
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.squareup.picasso.Picasso
import java.util.regex.Pattern

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

//@BindingAdapter("app:hideIfZero")
//fun hideIfZero(view: View, number: Int) {
//    view.visibility = if (number == 0) View.GONE else View.VISIBLE
//}

//@BindingAdapter("app:passwordValidator")
//fun passwordValidator(s:String?, theText: TextInputEditText){
//    s?.apply { if (isValidPassword() && toString().length >= 6) {
//            theText.error = null
//        }else{
//            theText.error = "Your Password is incorrect"
//        } }
//}

@BindingAdapter("app:error")
fun EditText.error(errorString: String?){
    error = if (errorString.toString().isValidPassword() && toString().length >= 6) {
        null
    }else{
        "Your Password is incorrect"
    }
}

@BindingAdapter("checksOut")
fun TextView.checksOut(checksOut: Boolean){
    compoundDrawableTintList = ColorStateList.valueOf(Color.parseColor(if(checksOut){
        "#9349DE"
    }else{
        "#EBE8E8"
    }))
}

fun CharSequence.isValidPassword(): Boolean {
    val passwordPattern = "^(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
    val pattern = Pattern.compile(passwordPattern)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}
package com.example.project.general

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import java.io.Serializable

fun <F, S>Pair<F, S>.toAndroidX() = androidx.core.util.Pair(first, second)

fun Activity.makeAnimationBundle(vararg pairs: Pair<View, String>): Bundle?{
    val androidxPairs: Array<androidx.core.util.Pair<View, String>> = Array(pairs.size){ pairs[it].toAndroidX() }
    return ActivityOptionsCompat.makeSceneTransitionAnimation(this, *androidxPairs).toBundle()
}

inline fun <reified T: Activity> Context.startActivityWithClass(
    vararg extras: Pair<String, Any?> = arrayOf(),
    flags: Int = 0,
    options: Bundle? = null
): Context {
    startActivity(Intent(this, T::class.java).apply {
        addFlags(flags)
        withExtras(*extras)
    }, options)
    return this
}

inline fun <reified T: Activity> Activity.startActivityWithClassForResult(
    vararg extras: Pair<String, Any?> = arrayOf(),
    flags: Int = 0,
    requestCode: Int,
    options: Bundle? = null
): Activity {
    startActivityForResult(Intent(this, T::class.java).apply {
        addFlags(flags)
        withExtras(*extras)
    }, requestCode, options)
    return this
}

fun Intent.withExtras(vararg data: Pair<String, Any?>) {
    data.forEach {
        val key = it.first
        when (val value = it.second) {
            is Int -> putExtra(key, value)
            is Byte -> putExtra(key, value)
            is Char -> putExtra(key, value)
            is Long -> putExtra(key, value)
            is Float -> putExtra(key, value)
            is Short -> putExtra(key, value)
            is Double -> putExtra(key, value)
            is Boolean -> putExtra(key, value)
            is Bundle -> putExtra(key, value)
            is String -> putExtra(key, value)
            is IntArray -> putExtra(key, value)
            is ByteArray -> putExtra(key, value)
            is CharArray -> putExtra(key, value)
            is LongArray -> putExtra(key, value)
            is FloatArray -> putExtra(key, value)
            is Parcelable -> putExtra(key, value)
            is ShortArray -> putExtra(key, value)
            is DoubleArray -> putExtra(key, value)
            is BooleanArray -> putExtra(key, value)
            is CharSequence -> putExtra(key, value)
            is Serializable -> putExtra(key, value)
        }
    }
}
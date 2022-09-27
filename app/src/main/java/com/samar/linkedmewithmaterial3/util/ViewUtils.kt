package com.samar.linkedmewithmaterial3.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.widget.Toast

object ViewUtils {

    fun Context.showToast(message: String?) {
        Toast.makeText(this, message ?: "some error", Toast.LENGTH_SHORT).show()
    }

    fun Context.findActivity(): Activity? = when (this) {
        is Activity -> this
        is ContextWrapper -> baseContext.findActivity()
        else -> null
    }


}
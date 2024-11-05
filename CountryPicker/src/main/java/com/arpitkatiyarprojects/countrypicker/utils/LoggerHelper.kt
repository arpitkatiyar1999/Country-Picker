package com.arpitkatiyarprojects.countrypicker.utils

import android.util.Log

internal object LoggerHelper {
    private const val LOG_TAG = "CountryPicker"

    fun logError(exception: Exception) {
        Log.e(LOG_TAG, exception.message, exception)
    }
}
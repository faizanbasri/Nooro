package com.nooro.core.utils

import android.content.Context
import com.nooro.R
import com.nooro.core.networkUtils.NetworkError

fun NetworkError.toErrorString(context: Context): String {
    val resId = when (this) {
        NetworkError.IN_VALID_API_KEY -> R.string.in_valid_api_key
        NetworkError.NO_LOCATION_FOUND -> R.string.no_location_found
        NetworkError.NO_INTERNET -> R.string.error_no_internet
        NetworkError.TOO_MANY_REQUEST -> R.string.too_many_request
        NetworkError.UNKNOWN -> R.string.unknown
    }
    return context.getString(resId)
}
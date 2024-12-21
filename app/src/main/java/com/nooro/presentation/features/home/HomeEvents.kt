package com.nooro.presentation.features.home

import com.nooro.core.networkUtils.NetworkError


sealed interface HomeEvents {
    data class Error(val error: NetworkError) : HomeEvents
}
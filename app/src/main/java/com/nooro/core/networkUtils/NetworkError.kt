package com.nooro.core.networkUtils

enum class NetworkError : Error {
    IN_VALID_API_KEY,
    NO_LOCATION_FOUND,
    NO_INTERNET,
    TOO_MANY_REQUEST,
    UNKNOWN,
}
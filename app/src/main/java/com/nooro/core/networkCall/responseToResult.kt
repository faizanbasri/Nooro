package com.nooro.core.networkCall

import com.nooro.core.networkUtils.NetworkError
import com.nooro.core.networkUtils.Result
import retrofit2.Response

inline fun <reified T> responseToResult(response: Response<T>): Result<T, NetworkError> {
    return when (response.code()) {
        in 200..399 -> {
             if (response.body() == null) {
                    Result.Error(NetworkError.UNKNOWN)
                }
             
            try {
                    Result.Success(response.body()!!)
            } catch (e: Exception) {
                Result.Error(NetworkError.UNKNOWN)
            }
        }
        400 -> Result.Error(NetworkError.NO_LOCATION_FOUND)
        401 -> Result.Error(NetworkError.IN_VALID_API_KEY)
        403 -> Result.Error(NetworkError.TOO_MANY_REQUEST)
        10000 -> Result.Error(NetworkError.NO_INTERNET)
        else -> Result.Error(NetworkError.UNKNOWN)
    }
}

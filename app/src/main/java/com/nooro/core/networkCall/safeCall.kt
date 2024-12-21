package com.nooro.core.networkCall

import com.nooro.core.networkUtils.NetworkError
import com.nooro.core.networkUtils.Result
import kotlinx.coroutines.ensureActive
import retrofit2.Response
import java.net.UnknownHostException
import java.nio.channels.UnresolvedAddressException
import kotlin.coroutines.coroutineContext

suspend inline fun <reified T> safeCall(execute: () -> Response<T>): Result<T, NetworkError> {
    val response = try {
        execute()
    } catch (e: UnknownHostException) {
        return Result.Error(NetworkError.NO_INTERNET)
    } catch (e: UnresolvedAddressException) {
        return Result.Error(NetworkError.UNKNOWN)
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        return Result.Error(NetworkError.UNKNOWN)
    }

    return responseToResult(response)
}
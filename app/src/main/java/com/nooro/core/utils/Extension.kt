package com.nooro.core.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.shareIn

fun <T> debounceFlow(
    waitMs: Long,
    coroutineScope: CoroutineScope,
    flow: Flow<T>
): Flow<T> = flow
    .debounce(waitMs)
    .distinctUntilChanged()
    .flowOn(Dispatchers.Default)
    .shareIn(coroutineScope, SharingStarted.Lazily, 1)
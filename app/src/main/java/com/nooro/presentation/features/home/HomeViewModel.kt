package com.nooro.presentation.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nooro.core.networkUtils.onError
import com.nooro.core.networkUtils.onSuccess
import com.nooro.data.repository.home.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val mRepo: HomeRepository) : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state = _state
        .onStart { getWeather() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            HomeState()
        )

    private val _events = Channel<HomeEvents>()
    val events = _events.receiveAsFlow()

    fun onAction(action: HomeAction) {
        when (action) {
            is HomeAction.OnSearchWeather -> {
                searchWeather(action.locationName)
            }
        }
    }

    private fun getWeather() {
        _state.update { it.copy() }
        viewModelScope.launch {
            mRepo.getSavedWeather()
                .onSuccess { weather -> _state.update { it.copy(weatherData = weather) } }
        }
    }

    private fun searchWeather(locationName: String) {
        _state.update { it.copy() }
        viewModelScope.launch {
            mRepo.searchWeather(locationName)
                .onSuccess { weather -> _state.update { it.copy(weatherData = weather) } }
                .onError { error -> _events.send(HomeEvents.Error(error)) }
        }
    }

}
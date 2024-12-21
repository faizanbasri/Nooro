package com.nooro.presentation.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.nooro.core.utils.Constants.uiWeatherData
import com.nooro.presentation.features.commonComponents.CommonSearchCard
import com.nooro.presentation.features.home.components.HomeWeatherDetail
import com.nooro.presentation.features.home.components.HomeWithNoSearch


@Composable
fun HomeScreen(
    state: HomeState,
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit
) {
    val weatherData = state.weatherData
    Column(
        modifier = modifier.background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CommonSearchCard(isEditable = false, onSearch = {}, onSearchClick = { onSearchClick() })

        if (weatherData == null) {
            Box(
                modifier = modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                HomeWithNoSearch(modifier = modifier)
            }
        } else {
            HomeWeatherDetail(modifier = modifier, data = weatherData)
        }
    }
}

@Composable
@PreviewLightDark
fun HomeScreenPreview() {
    HomeScreen(state = HomeState(false, uiWeatherData), onSearchClick = {})
}
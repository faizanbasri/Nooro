package com.nooro.presentation.features.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nooro.presentation.features.commonComponents.CommonSearchCard
import com.nooro.presentation.features.home.HomeState
import com.nooro.presentation.features.search.components.SearchCard


@Composable
fun SearchScreen(
    state: HomeState,
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit,
    onSearchClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CommonSearchCard(isEditable = true, onSearch = { onSearch(it) }) {

        }

        Box(
            modifier
                .fillMaxSize()
                .padding(48.dp, 0.dp, 48.dp, 0.dp)) {
            SearchCard(data = state.weatherData, modifier = modifier.clickable { onSearchClick() })
        }

    }
}
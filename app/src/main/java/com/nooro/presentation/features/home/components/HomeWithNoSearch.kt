package com.nooro.presentation.features.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp
import com.nooro.R
import com.nooro.ui.theme.Poppins


@Composable
fun HomeWithNoSearch(modifier:Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.no_city_selected),
            fontSize = 30.sp,
            fontFamily = Poppins,
        )
        Text(
            text = stringResource(R.string.please_search_for_a_city),
            fontSize = 15.sp,
            fontFamily = Poppins,
        )
    }
}

@Composable
@PreviewLightDark
fun HomeWithNoSearchPreview() {
    HomeWithNoSearch(Modifier)
}
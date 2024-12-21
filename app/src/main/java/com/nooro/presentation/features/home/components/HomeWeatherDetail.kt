package com.nooro.presentation.features.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.nooro.R
import com.nooro.domain.presentation.models.home.UIWeather
import com.nooro.ui.theme.Poppins
import com.nooro.ui.theme.TextColor


@Composable
fun HomeWeatherDetail(modifier: Modifier, data: UIWeather) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxHeight()
            .background(Color.White)
    ) {

        AsyncImage(
            modifier = modifier
                .height(150.dp)
                .width(150.dp),
            model = "https:${data.weatherIcon ?: ""}",
            contentDescription = data.weatherText
        )
        Row {
            Text(
                text = data.locationName ?: "",
                fontSize = 30.sp,
                fontFamily = Poppins,
                color = TextColor
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_navigation),
                contentDescription = stringResource(R.string.search),
                modifier = Modifier
                    .height(36.dp)
                    .width(36.dp),
                tint = TextColor
            )
        }
        Text(
            text = "${data.weatherTemp ?: "0"} °",
            fontSize = 70.sp,
            fontFamily = Poppins,
            color = TextColor
        )
        Spacer(modifier.height(8.dp))
        HomeWeatherCard(data = data)
    }
}
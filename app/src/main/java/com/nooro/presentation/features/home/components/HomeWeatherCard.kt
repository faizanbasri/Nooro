package com.nooro.presentation.features.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nooro.R
import com.nooro.core.utils.Constants.uiWeatherData
import com.nooro.domain.presentation.models.home.UIWeather
import com.nooro.ui.theme.CardBackGround
import com.nooro.ui.theme.Gray
import com.nooro.ui.theme.LightGray
import com.nooro.ui.theme.Poppins


@Composable
fun HomeWeatherCard(data: UIWeather) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardBackGround
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .width(300.dp)
                .padding(16.dp)
        ) {
            HomeWeatherCardDetail(
                title = stringResource(R.string.humidity),
                description = "${data.weatherHumidity ?: "0"}%"
            )

            Spacer(modifier = Modifier.width(20.dp))
            HomeWeatherCardDetail(
                title = stringResource(R.string.uv),
                description = "${data.weatherUv ?: "0"}"
            )

            Spacer(modifier = Modifier.width(20.dp))
            HomeWeatherCardDetail(
                title = stringResource(R.string.feel_like),
                description = "${data.weatherFeelLike ?: "0"} °"
            )
        }
    }
}

@Composable
fun HomeWeatherCardDetail(title: String, description: String) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontSize = 12.sp,
            fontFamily =Poppins,
            color = LightGray
        )
        Text(
            text = description,
            fontSize = 15.sp,
            fontFamily =Poppins,
            color = Gray
        )
    }
}

@Composable
@PreviewLightDark
fun HomeWeatherPreview() {
    HomeWeatherCard(data = uiWeatherData)
}
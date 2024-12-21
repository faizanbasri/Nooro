package com.nooro.presentation.features.search.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.nooro.domain.presentation.models.home.UIWeather
import com.nooro.ui.theme.CardBackGround
import com.nooro.ui.theme.Poppins
import com.nooro.ui.theme.TextColor


@Composable
fun SearchCard(data: UIWeather?, modifier: Modifier) {
    data?.apply {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = CardBackGround
            ),
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth().padding(0.dp)
            ) {
                Column(horizontalAlignment = Alignment.Start, modifier = modifier.weight(1f).padding(16.dp)) {
                    Text(
                        text = data.locationName ?: "",
                        fontSize = 20.sp,
                        fontFamily =Poppins,
                        color = TextColor
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "${data.weatherTemp ?: "0"} °",
                        fontSize = 60.sp,
                        fontFamily =Poppins,
                        color = TextColor
                    )
                }
                AsyncImage(
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .align(Alignment.CenterVertically),
                    alignment = Alignment.CenterEnd,
                    model = "https:${data.weatherIcon ?: ""}",
                    contentDescription = data.weatherText
                )
            }
        }
    }

}
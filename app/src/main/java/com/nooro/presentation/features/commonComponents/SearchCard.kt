package com.nooro.presentation.features.commonComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nooro.R
import com.nooro.ui.theme.CardBackGround
import com.nooro.ui.theme.LightGray
import com.nooro.ui.theme.Poppins


@Composable
fun CommonSearchCard(isEditable: Boolean, onSearch: (String) -> Unit, onSearchClick: () -> Unit) {
    var searchedText by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Card(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(52.dp)
            .clickable {
                onSearchClick()
            },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardBackGround
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
        ) {
            if (!isEditable) {
                Text(
                    text = stringResource(R.string.search_location),
                    color = LightGray,
                    modifier = Modifier.weight(3f),
                    fontFamily = Poppins,
                    fontSize = 15.sp
                )

            } else {
                TextField(
                    value = searchedText,
                    onValueChange = { newText ->
                        searchedText = newText
                    },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .onFocusChanged { focusState ->
                            if (!focusState.isFocused && searchedText.isNotBlank()) {
                                onSearch(searchedText)
                            }
                        },
                    placeholder = { Text(text = stringResource(id = R.string.search_location)) },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedPlaceholderColor = LightGray,
                        unfocusedPlaceholderColor = LightGray,
                        focusedTextColor = LightGray,
                        focusedLabelColor = LightGray
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                        }
                    )
                )
            }
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(R.string.search),
                modifier = Modifier
                    .height(36.dp)
                    .width(36.dp),
                tint = LightGray
            )
        }
    }
}

@Composable
@PreviewLightDark
fun SearchCardPreview() {
    CommonSearchCard(true, {}, {})
}
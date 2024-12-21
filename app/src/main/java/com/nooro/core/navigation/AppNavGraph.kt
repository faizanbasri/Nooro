package com.nooro.core.navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nooro.core.utils.ObserveAsEvents
import com.nooro.core.utils.toErrorString
import com.nooro.presentation.features.home.HomeAction
import com.nooro.presentation.features.home.HomeEvents
import com.nooro.presentation.features.home.HomeScreen
import com.nooro.presentation.features.home.HomeViewModel
import com.nooro.presentation.features.search.SearchScreen

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier, viewModel: HomeViewModel = hiltViewModel<HomeViewModel>()
) {
    val navController = rememberNavController()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current
    ObserveAsEvents(events = viewModel.events) { event ->
        when (event) {
            is HomeEvents.Error -> {
                Toast.makeText(
                    context,
                    event.error.toErrorString(context),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen(modifier = modifier, state = state) {
                navController.navigate("search")
            }
        }

        composable("search") {
            SearchScreen(modifier = modifier, state = state, onSearch = {
                viewModel.onAction(HomeAction.OnSearchWeather(locationName = it))
            }) {
                navController.popBackStack()
            }
        }
    }
}
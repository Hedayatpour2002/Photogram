package com.example.photogram

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.photogram.view.home.HomeScreen
import com.example.photogram.view.profile.ProfileScreen
import com.example.photogram.view.search.SearchScreen

@Composable
fun NavigationHost(navController: NavHostController, modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ) {
        composable(Screen.Home.route) {
            HomeScreen(listState = listState, modifier = modifier.padding(horizontal = 8.dp))
        }
        composable(Screen.Search.route) {
            SearchScreen(modifier = modifier.padding(horizontal = 8.dp))
        }
        composable(Screen.Profile.route) {
            ProfileScreen()
        }
    }
}

enum class Screen(val icon: ImageVector, val route: String) {
    Home(icon = Icons.Default.Home, route = "home"), Search(
        icon = Icons.Default.Search, route = "search"
    ),
    Profile(icon = Icons.Default.Person, route = "profile")
}
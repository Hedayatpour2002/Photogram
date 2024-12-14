package com.example.photogram

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.photogram.view.home.HomeScreen
import com.example.photogram.view.profile.ProfileScreen


@Composable
fun NavigationHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController, startDestination = Screen.HOME.route, modifier = modifier
    ) {
        composable(Screen.HOME.route) { HomeScreen() }
        composable(Screen.PROFILE.route) { ProfileScreen() }
    }
}

enum class Screen(val route: String, val title: String, @DrawableRes val icon: Int) {
    HOME("main", "Main", R.drawable.ic_home), PROFILE("profile", "Profile", R.drawable.ic_profile)
}

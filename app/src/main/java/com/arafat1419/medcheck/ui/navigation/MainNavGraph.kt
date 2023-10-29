package com.arafat1419.medcheck.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.arafat1419.medcheck.ui.features.main.home.HomeScreen
import com.arafat1419.medcheck.ui.features.main.profile.ProfileScreen
import com.arafat1419.medcheck.ui.navigation.model.MainNavOption

@Composable
fun MainNavGraph(
    navController: NavHostController
) {
    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = MainNavOption.HOME_SCREEN.name
    ) {
        composable(MainNavOption.HOME_SCREEN.name) {
            HomeScreen()
        }
        composable(MainNavOption.PROFILE_SCREEN.name) {
            ProfileScreen()
        }
    }
}
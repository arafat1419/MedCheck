package com.arafat1419.medcheck.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arafat1419.medcheck.ui.features.auth.login.LoginScreen
import com.arafat1419.medcheck.ui.features.auth.register.RegisterScreen
import com.arafat1419.medcheck.ui.features.main.MainScreen
import com.arafat1419.medcheck.ui.navigation.model.Navigation

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: Navigation = Navigation.LOGIN_ROUTE
) {
    val navActions = remember(navController) {
        NavigationActions(navController)
    }

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination.name
    ) {
        composable(Navigation.LOGIN_ROUTE.name) {
            LoginScreen(navigateTo = navActions::navigate)
        }
        composable(Navigation.REGISTER_ROUTE.name) {
            RegisterScreen(navigateTo = navActions::navigate)
        }
        composable(Navigation.MAIN_ROUTE.name) {
            MainScreen(navigateTo = navActions::navigate)
        }
    }
}
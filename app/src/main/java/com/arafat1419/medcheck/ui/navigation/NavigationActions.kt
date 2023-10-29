package com.arafat1419.medcheck.ui.navigation

import androidx.navigation.NavHostController
import com.arafat1419.medcheck.ui.navigation.model.Navigation

class NavigationActions(private val navHostController: NavHostController) {
    fun navigate(destination: Navigation) {
        navHostController.navigate(destination.toString()) {
            when (destination) {
                Navigation.MAIN_ROUTE -> {
                }

                else -> {}
            }
        }
    }
}


package com.arafat1419.medcheck.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.arafat1419.medcheck.ui.navigation.NavGraph
import com.arafat1419.medcheck.ui.navigation.model.Navigation
import com.arafat1419.medcheck.ui.theme.MedCheckTheme
import com.arafat1419.medcheck.utils.PreferenceManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedCheckTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MedCheckApp()
                }
            }
        }
    }
}

@Composable
fun MedCheckApp() {
    val navController = rememberNavController()
    val startDestination =
        if (PreferenceManager.getToken() == null) Navigation.LOGIN_ROUTE else Navigation.MAIN_ROUTE
    NavGraph(navController = navController, startDestination = startDestination)
}
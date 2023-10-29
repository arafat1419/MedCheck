package com.arafat1419.medcheck.ui.features.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.arafat1419.medcheck.ui.component.MainFooter
import com.arafat1419.medcheck.ui.component.MainToolbar
import com.arafat1419.medcheck.ui.component.NavigationDrawerSheet
import com.arafat1419.medcheck.ui.navigation.MainNavGraph
import com.arafat1419.medcheck.ui.navigation.model.MainNavOption
import com.arafat1419.medcheck.ui.navigation.model.Navigation
import com.arafat1419.medcheck.ui.theme.DarkBlue
import com.arafat1419.medcheck.utils.ComponentHelper.advancedShadow
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navigateTo: (Navigation) -> Unit,
) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    NavigationDrawerSheet(
        modifier = Modifier,
        drawerState = drawerState,
        coroutineScope = scope,
        navController = navController,
        navigateTo = {
            navigateTo(it)
        }
    ) {

        Column {
            MainToolbar(
                modifier = Modifier
                    .padding(top = 32.dp, start = 20.dp, end = 20.dp, bottom = 32.dp),
                onMenuClicked = {
                    scope.launch {
                        if (drawerState.isOpen) {
                            drawerState.close()
                        } else {
                            drawerState.open()
                        }
                    }
                }
            )

            LazyColumn(
                modifier = Modifier
                    .background(Color.White)
            ) {

                item {
                    MainNavGraph(navController = navController)
                }

                item {
                    val footerModifier =
                        if (navController.currentDestination?.route == MainNavOption.HOME_SCREEN.name) {
                            Modifier
                        } else {
                            Modifier
                                .advancedShadow(
                                    color = DarkBlue,
                                    alpha = 0.16F,
                                    shadowBlurRadius = 24.dp,
                                    offsetY = (-16).dp
                                )
                        }

                    MainFooter(
                        modifier = footerModifier
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_2)
@Composable
fun HomePreview() {
    MainScreen(navigateTo = {})
}
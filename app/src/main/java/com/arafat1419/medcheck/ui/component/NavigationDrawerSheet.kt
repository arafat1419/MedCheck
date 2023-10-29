package com.arafat1419.medcheck.ui.component

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.arafat1419.medcheck.R
import com.arafat1419.medcheck.ui.navigation.model.MainNavOption
import com.arafat1419.medcheck.ui.navigation.model.Navigation
import com.arafat1419.medcheck.ui.theme.BackgroundDrawer
import com.arafat1419.medcheck.ui.theme.GilroyFontFamily
import com.arafat1419.medcheck.ui.theme.LightGrey
import com.arafat1419.medcheck.ui.theme.ProximaNovaFontFamily
import com.arafat1419.medcheck.ui.theme.Red60
import com.arafat1419.medcheck.ui.theme.Title
import com.arafat1419.medcheck.utils.PreferenceManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerSheet(
    modifier: Modifier = Modifier,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope,
    navController: NavHostController,
    navigateTo: (Navigation) -> Unit,
    content: @Composable () -> Unit
) {

    ModalNavigationDrawer(
        modifier = modifier,
        drawerState = drawerState,
        gesturesEnabled = false,
        drawerContent = {
            if (drawerState.isClosed) return@ModalNavigationDrawer

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                IconButton(
                    modifier = Modifier
                        .padding(start = 24.dp, top = 40.dp, end = 10.dp)
                        .size(20.dp),
                    onClick = {
                        coroutineScope.launch { drawerState.close() }
                    },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_close),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                ModalDrawerSheet(
                    modifier = Modifier
                        .weight(1F),
                    drawerShape = RoundedCornerShape(0.dp),
                    drawerContainerColor = Color.White,
                    drawerTonalElevation = 0.dp,
                ) {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 40.dp),
                    ) {
                        Spacer(modifier = modifier.fillMaxHeight(0.13F))

                        ProfileHeader(nameFontSize = 14.sp)

                        val currentRoute = navController.currentDestination?.route
                        val homeScreen = MainNavOption.HOME_SCREEN.name
                        val profileScreen = MainNavOption.PROFILE_SCREEN.name

                        NavigationDrawerButton(
                            modifier = modifier
                                .padding(top = 32.dp),
                            isSelected = currentRoute == homeScreen,
                            title = stringResource(R.string.beranda)
                        ) {
                            coroutineScope.launch {
                                if (currentRoute != homeScreen) {
                                    navController.navigate(homeScreen)
                                }
                                drawerState.close()
                            }
                        }

                        NavigationDrawerButton(
                            modifier = modifier,
                            isSelected = currentRoute == profileScreen,
                            title = stringResource(R.string.my_profile)
                        ) {
                            coroutineScope.launch {
                                if (currentRoute != profileScreen) {
                                    navController.navigate(profileScreen)
                                }
                                drawerState.close()
                            }
                        }

                        Button(
                            modifier = Modifier
                                .padding(top = 40.dp),
                            shape = RoundedCornerShape(23.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Red60,
                                contentColor = Color.White,
                            ),
                            onClick = {
                                PreferenceManager.clearAllData()
                                navigateTo(Navigation.LOGIN_ROUTE)
                            }
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(vertical = 4.dp, horizontal = 32.dp),
                                text = stringResource(R.string.logout),
                                fontSize = 11.sp,
                                fontFamily = GilroyFontFamily,
                                fontWeight = FontWeight.Normal,
                            )
                        }

                        Row(
                            modifier = modifier
                                .padding(top = 80.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val openBrowser = rememberLauncherForActivityResult(
                                ActivityResultContracts.StartActivityForResult()
                            ) {}

                            val listSocMed = listOf(
                                mapOf(R.drawable.ic_facebook to "https://www.facebook.com/Vascomm"),
                                mapOf(R.drawable.ic_instagram to "https://www.instagram.com/vascomm"),
                                mapOf(R.drawable.ic_twitter to "https://wa.me/628113304455"),
                            )

                            Text(
                                text = stringResource(R.string.follow_us_at),
                                fontSize = 16.sp,
                                fontFamily = GilroyFontFamily,
                                fontWeight = FontWeight.Medium,
                                color = Title,
                            )

                            Spacer(modifier = Modifier.width(6.dp))

                            listSocMed.forEach {
                                val map = it.entries.first()
                                IconButton(
                                    modifier = Modifier
                                        .padding(start = 6.dp)
                                        .size(14.dp),
                                    onClick = {
                                        Intent(
                                            Intent.ACTION_VIEW,
                                            Uri.parse(map.value)
                                        ).let { intent ->
                                            openBrowser.launch(intent)
                                        }
                                    },
                                ) {
                                    Icon(
                                        painter = painterResource(id = map.key),
                                        contentDescription = null,
                                        tint = Title
                                    )
                                }
                            }
                        }

                        Spacer(modifier = modifier.fillMaxHeight(0.77F))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                modifier = Modifier
                                    .clickable { },
                                text = stringResource(R.string.faq),
                                fontSize = 14.sp,
                                fontFamily = ProximaNovaFontFamily,
                                fontWeight = FontWeight.Bold,
                                color = LightGrey,
                            )

                            Text(
                                modifier = Modifier
                                    .clickable { },
                                text = stringResource(R.string.terms_and_condition),
                                fontSize = 14.sp,
                                fontFamily = ProximaNovaFontFamily,
                                fontWeight = FontWeight.Bold,
                                color = LightGrey,
                            )
                        }

                        Spacer(modifier = modifier.fillMaxHeight(0.1F))
                    }
                }
            }
        },
        content = content,
        scrimColor = BackgroundDrawer
    )
}
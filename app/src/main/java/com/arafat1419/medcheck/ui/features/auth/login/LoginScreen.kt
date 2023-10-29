package com.arafat1419.medcheck.ui.features.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.arafat1419.medcheck.R
import com.arafat1419.medcheck.ui.component.BottomSheetError
import com.arafat1419.medcheck.ui.component.LoadingScreen
import com.arafat1419.medcheck.ui.component.MainTextField
import com.arafat1419.medcheck.ui.component.MainTitleField
import com.arafat1419.medcheck.ui.component.PrimaryButton
import com.arafat1419.medcheck.ui.features.auth.component.AuthFooter
import com.arafat1419.medcheck.ui.features.auth.component.AuthHeader
import com.arafat1419.medcheck.ui.navigation.model.Navigation
import com.arafat1419.medcheck.utils.PreferenceManager
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    navigateTo: (Navigation) -> Unit,
    viewModel: LoginViewModel = koinViewModel()
) {
    LoginContent(viewModel = viewModel) {
        navigateTo(it)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel,
    navigateTo: (Navigation) -> Unit,
) {
    val loginUiState: LoginUiState by viewModel.loginUiState.collectAsState()

    Box {
        LazyColumn(
            modifier = modifier
                .background(Color.White)
        ) {
            item {
                AuthHeader(
                    modifier = modifier
                        .padding(top = 110.dp, start = 20.dp),
                    titleDesc = stringResource(id = R.string.title_login_desc)
                )

                MainTitleField(
                    modifier = Modifier.padding(top = 12.dp, start = 20.dp, end = 20.dp),
                    title = stringResource(R.string.email)
                )
                MainTextField(
                    modifier = Modifier.padding(top = 16.dp, start = 20.dp, end = 20.dp),
                    text = loginUiState.authParam.email,
                    hint = stringResource(R.string.email_hint),
                    keyboardType = KeyboardType.Email
                ) { value, isError ->
                    val updatedListErrorField = loginUiState.listErrorField
                    updatedListErrorField[0] = isError

                    viewModel.setLoginUiState(
                        loginUiState.copy(
                            authParam = loginUiState.authParam.copy(email = value),
                            listErrorField = updatedListErrorField
                        )
                    )
                }

                MainTitleField(
                    modifier = Modifier.padding(top = 40.dp, start = 20.dp, end = 20.dp),
                    title = stringResource(R.string.password),
                )
                MainTextField(
                    modifier = Modifier.padding(top = 16.dp, start = 20.dp, end = 20.dp),
                    text = loginUiState.authParam.password,
                    hint = stringResource(R.string.password_hint),
                    keyboardType = KeyboardType.Password
                ) { value, isError ->
                    val updatedListErrorField = loginUiState.listErrorField
                    updatedListErrorField[1] = isError

                    viewModel.setLoginUiState(
                        loginUiState.copy(
                            authParam = loginUiState.authParam.copy(password = value),
                            listErrorField = updatedListErrorField
                        )
                    )
                }

                PrimaryButton(
                    modifier = Modifier.padding(top = 40.dp, start = 20.dp, end = 20.dp),
                    text = stringResource(id = R.string.login),
                    isEnable = loginUiState.listErrorField.none { it },
                    endIcon = R.drawable.ic_arrow_right
                ) {
                    viewModel.login { authDomain ->
                        authDomain.token?.let { PreferenceManager.saveToken(it) }
                        navigateTo(Navigation.MAIN_ROUTE)
                    }
                }

                AuthFooter(
                    modifier = Modifier.padding(top = 30.dp, bottom = 40.dp),
                    text = stringResource(R.string.login_footer_text),
                    actionText = stringResource(R.string.login_footer_action)
                ) {
                    navigateTo(Navigation.REGISTER_ROUTE)
                }
            }
        }

        if (loginUiState.isLoading) {
            LoadingScreen(modifier = modifier)
        }

        if (loginUiState.errorData != null) {
            BottomSheetError(
                modifier = modifier,
                title = loginUiState.errorData?.message.toString(),
                message = "Error Code: ${loginUiState.errorData?.code}"
            ) {
                viewModel.setLoginUiState(loginUiState.copy(errorData = null))
            }
        }
    }
}
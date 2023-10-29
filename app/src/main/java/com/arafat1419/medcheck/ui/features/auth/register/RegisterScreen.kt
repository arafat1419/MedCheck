package com.arafat1419.medcheck.ui.features.auth.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.arafat1419.core.vo.ErrorData
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
fun RegisterScreen(
    navigateTo: (Navigation) -> Unit,
    viewModel: RegisterViewModel = koinViewModel()
) {

    RegisterContent(viewModel = viewModel) {
        navigateTo(it)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterContent(
    modifier: Modifier = Modifier,
    viewModel: RegisterViewModel,
    navigateTo: (Navigation) -> Unit,
) {
    val registerUiState: RegisterUiState by viewModel.registerUiState.collectAsState()

    Box {
        LazyColumn(
            modifier = modifier
                .background(Color.White)
        ) {
            item {
                AuthHeader(
                    modifier = modifier
                        .padding(top = 110.dp, start = 20.dp),
                    titleDesc = stringResource(id = R.string.title_register_desc)
                )
            }

            item {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(top = 40.dp),
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1F)
                        ) {
                            MainTitleField(
                                title = stringResource(R.string.first_name)
                            )
                            MainTextField(
                                modifier = Modifier.padding(top = 16.dp),
                                hint = stringResource(R.string.first_name_hint),
                                text = registerUiState.registerFields.firstName
                            ) { value, isError ->
                                val updatedListErrorField = registerUiState.listErrorField
                                updatedListErrorField[0] = isError

                                viewModel.setRegisterUiState(
                                    registerUiState.copy(
                                        registerFields = registerUiState.registerFields.copy(
                                            firstName = value
                                        ),
                                        listErrorField = updatedListErrorField
                                    )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(35.dp))

                        Column(
                            modifier = Modifier
                                .weight(1F)
                        ) {
                            MainTitleField(
                                title = stringResource(R.string.last_name)
                            )
                            MainTextField(
                                modifier = Modifier.padding(top = 16.dp),
                                hint = stringResource(R.string.last_name_hint),
                                text = registerUiState.registerFields.lastName
                            ) { value, isError ->
                                val updatedListErrorField = registerUiState.listErrorField
                                updatedListErrorField[1] = isError

                                viewModel.setRegisterUiState(
                                    registerUiState.copy(
                                        registerFields = registerUiState.registerFields.copy(
                                            lastName = value
                                        ),
                                        listErrorField = updatedListErrorField
                                    )
                                )
                            }
                        }
                    }

                    MainTitleField(
                        modifier = Modifier.padding(top = 40.dp),
                        title = stringResource(R.string.identity_number)
                    )
                    MainTextField(
                        modifier = Modifier.padding(top = 16.dp),
                        hint = stringResource(R.string.identity_number_hint),
                        keyboardType = KeyboardType.Number,
                        text = registerUiState.registerFields.identityNumber
                    ) { value, isError ->
                        val updatedListErrorField = registerUiState.listErrorField
                        updatedListErrorField[2] = isError

                        viewModel.setRegisterUiState(
                            registerUiState.copy(
                                registerFields = registerUiState.registerFields.copy(identityNumber = value),
                                listErrorField = updatedListErrorField
                            )
                        )
                    }

                    MainTitleField(
                        modifier = Modifier.padding(top = 40.dp),
                        title = stringResource(R.string.email)
                    )
                    MainTextField(
                        modifier = Modifier.padding(top = 16.dp),
                        hint = stringResource(R.string.email_hint),
                        keyboardType = KeyboardType.Email,
                        text = registerUiState.registerFields.email
                    ) { value, isError ->
                        val updatedListErrorField = registerUiState.listErrorField
                        updatedListErrorField[3] = isError

                        viewModel.setRegisterUiState(
                            registerUiState.copy(
                                authParam = registerUiState.authParam.copy(email = value),
                                registerFields = registerUiState.registerFields.copy(email = value),
                                listErrorField = updatedListErrorField
                            )
                        )
                    }

                    MainTitleField(
                        modifier = Modifier.padding(top = 40.dp),
                        title = stringResource(R.string.phone_number)
                    )
                    MainTextField(
                        modifier = Modifier.padding(top = 16.dp),
                        hint = stringResource(R.string.phone_number_hint),
                        keyboardType = KeyboardType.Phone,
                        text = registerUiState.registerFields.phoneNumber
                    ) { value, isError ->
                        val updatedListErrorField = registerUiState.listErrorField
                        updatedListErrorField[4] = isError

                        viewModel.setRegisterUiState(
                            registerUiState.copy(
                                registerFields = registerUiState.registerFields.copy(phoneNumber = value),
                                listErrorField = updatedListErrorField
                            )
                        )
                    }

                    MainTitleField(
                        modifier = Modifier.padding(top = 40.dp),
                        title = stringResource(R.string.password)
                    )
                    MainTextField(
                        modifier = Modifier.padding(top = 16.dp),
                        hint = stringResource(R.string.password_hint),
                        keyboardType = KeyboardType.Password,
                        text = registerUiState.registerFields.password
                    ) { value, isError ->
                        val updatedListErrorField = registerUiState.listErrorField
                        updatedListErrorField[5] = isError

                        viewModel.setRegisterUiState(
                            registerUiState.copy(
                                authParam = registerUiState.authParam.copy(password = value),
                                registerFields = registerUiState.registerFields.copy(password = value),
                                listErrorField = updatedListErrorField
                            )
                        )
                    }

                    MainTitleField(
                        modifier = Modifier.padding(top = 40.dp),
                        title = stringResource(R.string.confirm_password)
                    )
                    MainTextField(
                        modifier = Modifier.padding(top = 16.dp),
                        hint = stringResource(R.string.confirm_password_hint),
                        keyboardType = KeyboardType.Password,
                        text = registerUiState.registerFields.confirmPassword
                    ) { value, isError ->
                        val updatedListErrorField = registerUiState.listErrorField
                        updatedListErrorField[6] = isError

                        viewModel.setRegisterUiState(
                            registerUiState.copy(
                                registerFields = registerUiState.registerFields.copy(confirmPassword = value),
                                listErrorField = updatedListErrorField
                            )
                        )
                    }

                    PrimaryButton(
                        modifier = Modifier.padding(top = 40.dp),
                        text = stringResource(R.string.register),
                        endIcon = R.drawable.ic_arrow_right,
                        isEnable = registerUiState.listErrorField.none { it }
                    ) {
                        if (registerUiState.registerFields.password == registerUiState.registerFields.confirmPassword) {
                            viewModel.register { authDomain ->
                                authDomain.token?.let { PreferenceManager.saveToken(it) }
                                navigateTo(Navigation.MAIN_ROUTE)
                            }
                        } else {
                            viewModel.setRegisterUiState(
                                registerUiState.copy(
                                    errorData = ErrorData(
                                        "500",
                                        "Konfirmasi password salah"
                                    )
                                )
                            )
                        }
                    }

                    AuthFooter(
                        modifier = Modifier.padding(top = 30.dp, bottom = 40.dp),
                        text = stringResource(R.string.register_footer_text),
                        actionText = stringResource(R.string.register_footer_action)
                    ) {
                        navigateTo(Navigation.LOGIN_ROUTE)
                    }
                }
            }
        }

        if (registerUiState.isLoading) {
            LoadingScreen(modifier = modifier)
        }

        if (registerUiState.errorData != null) {
            BottomSheetError(
                modifier = modifier,
                title = registerUiState.errorData?.message.toString(),
                message = "Error Code: ${registerUiState.errorData?.code}"
            ) {
                viewModel.setRegisterUiState(registerUiState.copy(errorData = null))
            }
        }
    }

}
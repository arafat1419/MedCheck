package com.arafat1419.medcheck.ui.features.main.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arafat1419.medcheck.R
import com.arafat1419.medcheck.ui.component.MainTextField
import com.arafat1419.medcheck.ui.component.MainTitleField
import com.arafat1419.medcheck.ui.component.PrimaryButton
import com.arafat1419.medcheck.ui.component.ProfileHeader
import com.arafat1419.medcheck.ui.features.main.home.component.ListOption
import com.arafat1419.medcheck.ui.theme.BackgroundProfile
import com.arafat1419.medcheck.ui.theme.Black33
import com.arafat1419.medcheck.ui.theme.DarkBlue
import com.arafat1419.medcheck.ui.theme.GilroyFontFamily
import com.arafat1419.medcheck.ui.theme.LightGrey
import com.arafat1419.medcheck.ui.theme.MediumGrey
import com.arafat1419.medcheck.ui.theme.Neutral30
import com.arafat1419.medcheck.ui.theme.ProximaNovaFontFamily
import com.arafat1419.medcheck.ui.theme.SoftBlue
import com.arafat1419.medcheck.ui.theme.SoftGreen
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = koinViewModel()
) {
    val profileUiState: ProfileUiState by viewModel.profileUiState.collectAsState()

    val options =
        listOf(stringResource(id = R.string.my_profile), stringResource(id = R.string.setting))
    var selectedOption by remember {
        mutableStateOf(options[0])
    }

    Column(
        modifier = modifier
            .background(BackgroundProfile)
            .padding(top = 40.dp, bottom = 77.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ListOption(
                modifier = Modifier,
                options = options,
                selectedOption = selectedOption
            ) {
                selectedOption = it
            }
        }

        Card(
            modifier = Modifier
                .padding(top = 40.dp, start = 32.dp, end = 32.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(Color.White),
            shape = RoundedCornerShape(20.dp)
        ) {
            Box(
                modifier = Modifier,
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(),
                    painter = painterResource(id = R.drawable.mask_profile_card),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )

                Column(
                    modifier = Modifier.matchParentSize()
                ) {
                    Spacer(modifier = Modifier.weight(1F))

                    ProfileHeader(
                        modifier = Modifier
                            .padding(horizontal = 26.dp),
                        nameFontSize = 14.sp,
                        fontColor = Color.White
                    )

                    Spacer(modifier = Modifier.weight(1F))

                    Text(
                        modifier = Modifier
                            .background(
                                SoftBlue, RoundedCornerShape(
                                    topStart = 20.dp,
                                    topEnd = 0.dp,
                                    bottomEnd = 20.dp,
                                    bottomStart = 20.dp
                                )
                            )
                            .padding(vertical = 12.dp, horizontal = 16.dp),
                        text = stringResource(R.string.profile_card_warning),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = ProximaNovaFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = Color.White,
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            Column(
                modifier = Modifier
                    .padding(horizontal = 30.dp)
            ) {
                Text(
                    text = stringResource(R.string.profile_form_title),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = DarkBlue,
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row {
                    Icon(
                        modifier = Modifier
                            .size(36.dp)
                            .background(SoftGreen, CircleShape)
                            .padding(8.dp),
                        painter = painterResource(id = R.drawable.ic_contact),
                        contentDescription = null,
                        tint = DarkBlue
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Data Diri",
                            fontSize = 14.sp,
                            fontFamily = GilroyFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = Black33,
                        )

                        Text(
                            text = "Data diri anda sesuai KTP",
                            fontSize = 10.sp,
                            fontFamily = ProximaNovaFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = LightGrey,
                        )
                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Icon(
                        modifier = Modifier
                            .size(36.dp)
                            .background(Neutral30, CircleShape)
                            .padding(8.dp),
                        painter = painterResource(id = R.drawable.ic_location),
                        contentDescription = null,
                        tint = MediumGrey
                    )
                }

                val fieldTitlePadding = PaddingValues(top = 30.dp)

                MainTitleField(
                    modifier = Modifier.padding(top = 44.dp),
                    title = stringResource(R.string.first_name)
                )
                MainTextField(
                    modifier = Modifier.padding(top = 16.dp),
                    hint = stringResource(R.string.first_name_hint),
                    text = profileUiState.profileFields.firstName
                ) { value, isError ->
                    val updatedListErrorField = profileUiState.listErrorField
                    updatedListErrorField[0] = isError

                    viewModel.setProfileUiState(
                        profileUiState.copy(
                            profileFields = profileUiState.profileFields.copy(
                                firstName = value
                            ),
                            listErrorField = updatedListErrorField
                        )
                    )
                }

                MainTitleField(
                    modifier = Modifier.padding(fieldTitlePadding),
                    title = stringResource(R.string.last_name)
                )
                MainTextField(
                    modifier = Modifier.padding(top = 16.dp),
                    hint = stringResource(R.string.last_name_hint),
                    text = profileUiState.profileFields.lastName
                ) { value, isError ->
                    val updatedListErrorField = profileUiState.listErrorField
                    updatedListErrorField[1] = isError

                    viewModel.setProfileUiState(
                        profileUiState.copy(
                            profileFields = profileUiState.profileFields.copy(
                                lastName = value
                            ),
                            listErrorField = updatedListErrorField
                        )
                    )
                }


                MainTitleField(
                    modifier = Modifier.padding(fieldTitlePadding),
                    title = stringResource(R.string.email)
                )
                MainTextField(
                    modifier = Modifier.padding(top = 16.dp),
                    hint = stringResource(R.string.email_hint),
                    text = profileUiState.profileFields.email,
                    keyboardType = KeyboardType.Email
                ) { value, isError ->
                    val updatedListErrorField = profileUiState.listErrorField
                    updatedListErrorField[2] = isError

                    viewModel.setProfileUiState(
                        profileUiState.copy(
                            profileFields = profileUiState.profileFields.copy(
                                email = value
                            ),
                            listErrorField = updatedListErrorField
                        )
                    )
                }

                MainTitleField(
                    modifier = Modifier.padding(fieldTitlePadding),
                    title = stringResource(R.string.phone_number)
                )
                MainTextField(
                    modifier = Modifier.padding(top = 16.dp),
                    hint = stringResource(R.string.phone_number_hint),
                    text = profileUiState.profileFields.phoneNumber,
                    keyboardType = KeyboardType.Phone
                ) { value, isError ->
                    val updatedListErrorField = profileUiState.listErrorField
                    updatedListErrorField[3] = isError

                    viewModel.setProfileUiState(
                        profileUiState.copy(
                            profileFields = profileUiState.profileFields.copy(
                                phoneNumber = value
                            ),
                            listErrorField = updatedListErrorField
                        )
                    )
                }

                MainTitleField(
                    modifier = Modifier.padding(fieldTitlePadding),
                    title = stringResource(R.string.identity_number)
                )
                MainTextField(
                    modifier = Modifier.padding(top = 16.dp),
                    hint = stringResource(R.string.identity_number_hint),
                    text = profileUiState.profileFields.identityNumber,
                    keyboardType = KeyboardType.Number
                ) { value, isError ->
                    val updatedListErrorField = profileUiState.listErrorField
                    updatedListErrorField[4] = isError

                    viewModel.setProfileUiState(
                        profileUiState.copy(
                            profileFields = profileUiState.profileFields.copy(
                                identityNumber = value
                            ),
                            listErrorField = updatedListErrorField
                        )
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(top = 43.dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .size(16.dp)
                            .padding(top = 3.dp),
                        painter = painterResource(id = R.drawable.ic_info),
                        contentDescription = null,
                        tint = DarkBlue
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        text = stringResource(R.string.profile_input_caution),
                        fontSize = 12.sp,
                        fontFamily = ProximaNovaFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = MediumGrey,
                        lineHeight = TextUnit(14.4F, TextUnitType.Sp)
                    )
                }

                PrimaryButton(
                    modifier = Modifier
                        .padding(top = 34.dp),
                    text = stringResource(R.string.save_profile),
                    endIcon = R.drawable.ic_save,
                    isEnable = profileUiState.listErrorField.none { it }
                ) {

                }

                Spacer(modifier = Modifier.height(31.dp))
            }
        }
    }
}
package com.arafat1419.medcheck.ui.features.main.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arafat1419.core.domain.model.ServiceItemDomain
import com.arafat1419.medcheck.R
import com.arafat1419.medcheck.ui.component.LoadingMoreData
import com.arafat1419.medcheck.ui.theme.DarkBlue
import com.arafat1419.medcheck.ui.theme.GilroyFontFamily
import kotlinx.coroutines.delay

@Composable
fun ListService(modifier: Modifier = Modifier) {
    var loading by remember { mutableStateOf(true) }
    LaunchedEffect(Unit) {
        delay(10000)
        loading = false
    }

    val serviceOne = ServiceItemDomain(
        id = 1,
        image = R.drawable.img_landmark_one,
        name = "PCR Swab Test (Drive Thru) Hasil 1 Hari Kerja",
        price = "Rp. 1.400.000",
        address = "Lenmarc Surabaya",
        district = "Dukuh Pakis",
        city = "Surabaya",
        type = stringResource(R.string.unit)
    )

    val serviceTwo = ServiceItemDomain(
        id = 2,
        image = R.drawable.img_landmark_two,
        name = "PCR Swab Test (Drive Thru) Hasil 1 Hari Kerja",
        price = "Rp. 1.800.000",
        address = "Lenmarc Surabaya",
        district = "Dukuh Pakis",
        city = "Surabaya",
        type = stringResource(R.string.inspection_package)
    )

    val services = listOf(
        serviceOne,
        serviceTwo,
        serviceOne.copy(id = 3),
        serviceTwo.copy(id = 4)
    )
    Column(modifier = modifier) {
        val options = listOf(
            stringResource(R.string.unit),
            stringResource(R.string.inspection_package)
        )
        var selectedOption by remember {
            mutableStateOf(options[0])
        }

        Text(
            text = stringResource(R.string.service_title),
            fontSize = 16.sp,
            fontFamily = GilroyFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = DarkBlue,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        ListOption(
            modifier = Modifier
                .padding(top = 22.dp),
            options = options,
            selectedOption = selectedOption
        ) {
            selectedOption = it
        }

        Spacer(modifier = Modifier.height(10.dp))

        services.filter {
            it.type == selectedOption
        }.forEach { value ->
            ListServiceItem(
                service = value,
            ) {

            }
        }

        if (loading) {
            LoadingMoreData(
                modifier = Modifier
                    .padding(top = 30.dp)
            )
        }
    }
}
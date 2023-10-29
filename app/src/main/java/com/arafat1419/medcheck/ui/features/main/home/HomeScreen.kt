package com.arafat1419.medcheck.ui.features.main.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.arafat1419.medcheck.R
import com.arafat1419.medcheck.ui.features.main.home.component.HomeHeaderItem
import com.arafat1419.medcheck.ui.features.main.home.component.HomeSliderItem
import com.arafat1419.medcheck.ui.features.main.home.component.ListProduct
import com.arafat1419.medcheck.ui.features.main.home.component.ListService

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(bottom = 40.dp)
    ) {
        HomeSliderItem(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
        ) {

        }

        HomeHeaderItem(
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp, end = 20.dp),
            title = stringResource(R.string.banner_one_title),
            desc = stringResource(R.string.banner_one_desc),
            actionText = stringResource(R.string.banner_one_action),
            illustration = R.drawable.ill_vaccine,
            isIllRight = true,
        ) {

        }

        HomeHeaderItem(
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp, end = 20.dp),
            title = stringResource(R.string.banner_two_title),
            desc = stringResource(R.string.banner_two_desc),
            actionText = stringResource(R.string.banner_two_action),
            illustration = R.drawable.ill_glass,
            isIllRight = false,
        ) {

        }

        ListProduct(
            modifier = Modifier
                .padding(top = 40.dp)
        )

        ListService(
            modifier = Modifier
                .padding(top = 40.dp, start = 20.dp, end = 20.dp)
        )
    }
}
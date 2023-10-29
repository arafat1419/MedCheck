package com.arafat1419.medcheck.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arafat1419.medcheck.R
import com.arafat1419.medcheck.ui.theme.LightGrey
import com.arafat1419.medcheck.ui.theme.ProximaNovaFontFamily

@Composable
fun LoadingMoreData(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_load),
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = stringResource(R.string.show_more),
            fontSize = 14.sp,
            fontFamily = ProximaNovaFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = LightGrey,
        )
    }
}
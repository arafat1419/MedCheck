package com.arafat1419.medcheck.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arafat1419.medcheck.R
import com.arafat1419.medcheck.ui.theme.MediumGrey
import com.arafat1419.medcheck.ui.theme.ProximaNovaFontFamily
import com.arafat1419.medcheck.ui.theme.SoftGrey

@Composable
fun NavigationDrawerButton(
    modifier: Modifier = Modifier,
    title: String,
    isSelected: Boolean,
    onItemClicked: () -> Unit
) {
    Column(modifier) {
        Row(
            modifier = Modifier
                .padding(top = 16.dp)
                .width(145.dp)
                .clickable { onItemClicked() },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                fontSize = 12.sp,
                fontFamily = ProximaNovaFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = SoftGrey,
            )

            Icon(
                modifier = Modifier
                    .size(16.dp),
                painter = painterResource(id = R.drawable.ic_angle_right),
                contentDescription = null,
                tint = MediumGrey
            )
        }

        if (isSelected) {
            Divider(
                modifier = Modifier
                    .height(1.dp)
                    .width(145.dp),
                color = SoftGrey
            )
        }
    }
}
package com.arafat1419.medcheck.ui.features.main.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arafat1419.core.domain.model.ServiceItemDomain
import com.arafat1419.medcheck.R
import com.arafat1419.medcheck.ui.theme.LightGrey
import com.arafat1419.medcheck.ui.theme.MediumGrey
import com.arafat1419.medcheck.ui.theme.Orange
import com.arafat1419.medcheck.ui.theme.ProximaNovaFontFamily
import com.arafat1419.medcheck.ui.theme.Title
import com.arafat1419.medcheck.utils.ComponentHelper.advancedShadow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListServiceItem(
    modifier: Modifier = Modifier,
    service: ServiceItemDomain,
    onItemClicked: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(top = 30.dp)
            .fillMaxWidth()
            .advancedShadow(
                color = LightGrey,
                alpha = 0.2F,
                shadowBlurRadius = 24.dp,
                offsetY = 16.dp
            ),
        onClick = { onItemClicked() },
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = Modifier
        ) {
            Column(
                modifier = Modifier
                    .weight(0.65F)
                    .padding(16.dp)
            ) {
                Text(
                    text = service.name,
                    fontSize = 14.sp,
                    fontFamily = ProximaNovaFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Title,
                    lineHeight = TextUnit(18F, TextUnitType.Sp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = service.price,
                    fontSize = 14.sp,
                    fontFamily = ProximaNovaFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Orange,
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.ic_hospital),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = service.address,
                        fontSize = 14.sp,
                        fontFamily = ProximaNovaFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = MediumGrey,
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.ic_location),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "${service.district}, ${service.city}",
                        fontSize = 12.sp,
                        fontFamily = ProximaNovaFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = LightGrey,
                    )
                }
            }

            Image(
                modifier = Modifier
                    .weight(0.33F),
                painter = painterResource(
                    id = service.image
                ),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
        }
    }
}
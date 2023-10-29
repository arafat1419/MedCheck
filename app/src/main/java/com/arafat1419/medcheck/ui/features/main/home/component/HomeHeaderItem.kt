package com.arafat1419.medcheck.ui.features.main.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.arafat1419.medcheck.R
import com.arafat1419.medcheck.ui.theme.DarkBlue
import com.arafat1419.medcheck.ui.theme.GilroyFontFamily
import com.arafat1419.medcheck.ui.theme.LightGrey
import com.arafat1419.medcheck.ui.theme.ProximaNovaFontFamily
import com.arafat1419.medcheck.ui.theme.RoyalBlue
import com.arafat1419.medcheck.utils.ComponentHelper.advancedShadow

@Composable
fun HomeHeaderItem(
    modifier: Modifier = Modifier,
    title: String,
    desc: String,
    actionText: String,
    @DrawableRes illustration: Int,
    isIllRight: Boolean = true,
    onActionTextClicked: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .zIndex(1f)
                .align(if (isIllRight) Alignment.TopEnd else Alignment.TopStart)
                .padding(
                    start = if (!isIllRight) 16.dp else 0.dp,
                    end = if (isIllRight) 16.dp else 0.dp,
                )
                .fillMaxWidth(0.35F),
            painter = painterResource(id = illustration),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Card(
            modifier = Modifier
                .padding(top = 12.dp)
                .advancedShadow(
                    color = LightGrey,
                    alpha = 0.2F,
                    shadowBlurRadius = 24.dp,
                    offsetY = 16.dp
                ),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                if (!isIllRight) {
                    Spacer(
                        modifier = Modifier
                            .weight(0.4F)
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(0.6F)
                ) {
                    Text(
                        text = title,
                        fontSize = 18.sp,
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = DarkBlue
                    )

                    Text(
                        modifier = Modifier
                            .padding(top = 12.dp),
                        text = desc,
                        fontSize = 12.sp,
                        fontFamily = ProximaNovaFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = RoyalBlue,
                        lineHeight = TextUnit(14F, TextUnitType.Sp)
                    )

                    Row(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .clickable {
                                onActionTextClicked()
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = actionText,
                            fontSize = 14.sp,
                            fontFamily = GilroyFontFamily,
                            fontWeight = FontWeight.Bold,
                            color = DarkBlue
                        )

                        Icon(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .size(16.dp),
                            painter = painterResource(id = R.drawable.ic_arrow_right),
                            contentDescription = null,
                            tint = DarkBlue
                        )
                    }
                }

                if (isIllRight) {
                    Spacer(
                        modifier = Modifier
                            .weight(0.4F)
                    )
                }
            }
        }
    }
}
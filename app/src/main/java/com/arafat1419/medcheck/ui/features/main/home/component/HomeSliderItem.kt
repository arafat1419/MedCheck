package com.arafat1419.medcheck.ui.features.main.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.arafat1419.medcheck.R
import com.arafat1419.medcheck.ui.theme.DarkBlue
import com.arafat1419.medcheck.ui.theme.GilroyFontFamily
import com.arafat1419.medcheck.ui.theme.ProximaNovaFontFamily
import com.arafat1419.medcheck.ui.theme.RoyalBlue
import com.arafat1419.medcheck.utils.ComponentHelper.advancedShadow

@Composable
fun HomeSliderItem(
    modifier: Modifier = Modifier,
    onButtonClicked: () -> Unit,
) {
    val totalSlide = 3
    var selectedItem by remember {
        mutableIntStateOf(0)
    }

    val listOfSlideImages =
        listOf(R.drawable.ill_calendar, R.drawable.ill_vaccine, R.drawable.ill_glass)

    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .zIndex(1f)
                .align(Alignment.TopEnd)
                .padding(
                    end = 12.dp
                )
                .fillMaxWidth(0.28F),
            painter = painterResource(id = listOfSlideImages[selectedItem]),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Card(
            modifier = Modifier
                .padding(top = 12.dp)
                .advancedShadow(
                    color = DarkBlue,
                    alpha = 0.24F,
                    shadowBlurRadius = 24.dp,
                    offsetY = 16.dp
                )
                .background(
                    brush = Brush.linearGradient(
                        0.0F to Color(0xFFFEFFEF),
                        0.2F to Color(0xFFFAFAFA),
                        1F to Color(0xFFDAE9F9),
                    ),
                    shape = RoundedCornerShape(16.dp)
                ),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.7F)
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.SemiBold,
                                )
                            ) {
                                append(stringResource(id = R.string.title_slider_first))
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.ExtraBold,
                                )
                            ) {
                                append(stringResource(id = R.string.title_slider_second))
                            }
                        },
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = GilroyFontFamily,
                            color = DarkBlue
                        )
                    )

                    Text(
                        modifier = Modifier
                            .padding(top = 12.dp),
                        text = stringResource(R.string.slider_desc),
                        fontSize = 12.sp,
                        fontFamily = ProximaNovaFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = RoyalBlue,
                        lineHeight = TextUnit(14F, TextUnitType.Sp)
                    )

                    Button(
                        modifier = Modifier
                            .padding(top = 16.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = DarkBlue,
                            contentColor = Color.White,
                        ),
                        onClick = { onButtonClicked() }
                    ) {
                        Text(
                            text = stringResource(R.string.slider_action),
                            fontSize = 12.sp,
                            fontFamily = GilroyFontFamily,
                            fontWeight = FontWeight.SemiBold,
                        )
                    }
                }

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(0.3F)
                        .padding(bottom = 8.dp)
                        .align(Alignment.BottomEnd),
                    horizontalArrangement = Arrangement.Center
                ) {
                    items(totalSlide) { index ->
                        val isSelected = index == selectedItem
                        Spacer(
                            modifier = Modifier
                                .width(if (isSelected) 40.dp else 8.dp)
                                .height(8.dp)
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .pointerInput(Unit) {
                                    detectTapGestures {
                                        selectedItem = index
                                    }
                                }
                        )
                        Spacer(modifier = Modifier.width(if (index + 1 == totalSlide) 0.dp else 10.dp))
                    }
                }
            }
        }
    }
}
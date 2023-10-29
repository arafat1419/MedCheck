package com.arafat1419.medcheck.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arafat1419.medcheck.ui.theme.BackgroundBlur
import com.arafat1419.medcheck.ui.theme.DarkBlue
import com.arafat1419.medcheck.ui.theme.MediumGrey
import com.arafat1419.medcheck.ui.theme.ProximaNovaFontFamily

@Composable
fun BottomSheetError(
    modifier: Modifier = Modifier,
    title: String,
    message: String,
    onCloseClick: () -> Unit
) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundBlur)
                .clickable {
                    onCloseClick()
                }
        )

        Card(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
                    .padding(vertical = 24.dp, horizontal = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontFamily = ProximaNovaFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = DarkBlue,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = message,
                    fontSize = 12.sp,
                    fontFamily = ProximaNovaFontFamily,
                    fontWeight = FontWeight.Normal,
                    color = MediumGrey,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(24.dp))

                PrimaryButton(
                    text = "Tutup",
                ) {
                    onCloseClick()
                }
            }
        }
    }
}
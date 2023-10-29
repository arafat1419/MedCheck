package com.arafat1419.medcheck.ui.features.main.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arafat1419.medcheck.ui.theme.LightGrey
import com.arafat1419.medcheck.ui.theme.ProximaNovaFontFamily
import com.arafat1419.medcheck.ui.theme.SeaBlue
import com.arafat1419.medcheck.ui.theme.Title
import com.arafat1419.medcheck.utils.ComponentHelper.advancedShadow

@Composable
fun ListOption(
    modifier: Modifier = Modifier,
    options: List<String>,
    selectedOption: String,
    onItemSelected: (value: String) -> Unit
) {
    Card(
        modifier = modifier
            .advancedShadow(
                color = LightGrey,
                alpha = 0.16F,
                shadowBlurRadius = 24.dp,
                offsetY = 16.dp
            ),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {

        LazyRow(
            modifier = Modifier
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(items = options) { value ->
                val isSelected = value == selectedOption


                ClickableText(
                    modifier = Modifier
                        .background(
                            if (isSelected) SeaBlue else Color.White,
                            RoundedCornerShape(20.dp)
                        )
                        .padding(vertical = 6.dp, horizontal = 16.dp),
                    text = AnnotatedString(value),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = ProximaNovaFontFamily,
                        fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                        color = Title,
                    )
                ) {
                    onItemSelected(value)
                }

                if (value != options.last()) {
                    Spacer(modifier = Modifier.width(12.dp))
                }
            }
        }
    }
}
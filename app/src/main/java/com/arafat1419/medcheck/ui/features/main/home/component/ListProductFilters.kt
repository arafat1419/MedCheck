package com.arafat1419.medcheck.ui.features.main.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arafat1419.medcheck.ui.theme.DarkBlue
import com.arafat1419.medcheck.ui.theme.GilroyFontFamily
import com.arafat1419.medcheck.ui.theme.LightGrey
import com.arafat1419.medcheck.utils.ComponentHelper.advancedShadow

@Composable
fun ListProductFilters(
    modifier: Modifier = Modifier,
    filters: List<String>,
    selectedFilter: String,
    onItemSelected: (value: String) -> Unit
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {

        items(filters) { value ->
            val isSelected = value == selectedFilter
            Button(
                modifier = Modifier
                    .padding(
                        start = 20.dp,
                        end = if (value == filters[filters.size - 1]) 20.dp else 0.dp
                    )
                    .advancedShadow(
                        color = if (isSelected) DarkBlue else LightGrey,
                        alpha = 0.24F,
                        shadowBlurRadius = 24.dp,
                        offsetY = 16.dp
                    ),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSelected) DarkBlue else Color.White,
                    contentColor = if (isSelected) Color.White else DarkBlue,
                ),
                onClick = { onItemSelected(value) }
            ) {
                Text(
                    text = value,
                    fontSize = 12.sp,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
    }
}

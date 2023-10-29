package com.arafat1419.medcheck.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arafat1419.medcheck.ui.theme.DarkBlue
import com.arafat1419.medcheck.ui.theme.GilroyFontFamily
import com.arafat1419.medcheck.ui.theme.Title
import com.arafat1419.medcheck.utils.ComponentHelper.advancedShadow

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    isEnable: Boolean = true,
    @DrawableRes endIcon: Int? = null,
    onButtonClicked: () -> Unit
) {
    val buttonModifier = if (isEnable) {
        modifier
            .fillMaxWidth()
            .height(48.dp)
            .advancedShadow(
                color = Title,
                alpha = 0.24F,
                shadowBlurRadius = 24.dp,
                offsetY = 16.dp
            )
    } else {
        modifier
            .fillMaxWidth()
            .height(48.dp)
    }

    Button(
        onClick = onButtonClicked,
        modifier = buttonModifier,
        enabled = isEnable,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = DarkBlue, contentColor = Color.White),
        contentPadding = PaddingValues(
            horizontal = 20.dp, vertical = 12.dp
        )
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F),
            text = text,
            fontSize = 16.sp,
            fontFamily = GilroyFontFamily,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )

        if (endIcon != null) {
            Icon(
                painter = painterResource(id = endIcon),
                contentDescription = null
            )
        }
    }
}
package com.arafat1419.medcheck.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.arafat1419.medcheck.ui.theme.GilroyFontFamily
import com.arafat1419.medcheck.ui.theme.ProximaNovaFontFamily
import com.arafat1419.medcheck.ui.theme.Simple
import com.arafat1419.medcheck.ui.theme.Title

@Composable
fun MainTitleField(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String? = null,
    onSubtitleClicked: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontFamily = GilroyFontFamily,
            fontWeight = FontWeight.SemiBold,
            style = TextStyle(
                color = Title
            )
        )

        if (subtitle != null) {
            ClickableText(
                text = AnnotatedString(subtitle),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = ProximaNovaFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Simple
                ),
                onClick = { onSubtitleClicked() }
            )
        }
    }
}
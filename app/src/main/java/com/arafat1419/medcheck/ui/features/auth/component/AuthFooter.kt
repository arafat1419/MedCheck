package com.arafat1419.medcheck.ui.features.auth.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arafat1419.medcheck.R
import com.arafat1419.medcheck.ui.theme.DarkBlue
import com.arafat1419.medcheck.ui.theme.LightGrey
import com.arafat1419.medcheck.ui.theme.ProximaNovaFontFamily

@Composable
fun AuthFooter(
    modifier: Modifier = Modifier,
    text: String,
    actionText: String,
    onActionTextClicked: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                fontSize = 14.sp,
                fontFamily = ProximaNovaFontFamily,
                fontWeight = FontWeight.Normal,
                color = LightGrey
            )

            ClickableText(
                modifier = Modifier
                    .padding(start = 12.dp),
                text = AnnotatedString(actionText),
                onClick = { onActionTextClicked() },
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = ProximaNovaFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = DarkBlue
                )
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_c_circle),
                contentDescription = null
            )
            Text(
                modifier = Modifier
                    .padding(start = 8.dp),
                text = "SILK. all right reserved.",
                fontSize = 12.sp,
                fontFamily = ProximaNovaFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = LightGrey
            )
        }
    }
}
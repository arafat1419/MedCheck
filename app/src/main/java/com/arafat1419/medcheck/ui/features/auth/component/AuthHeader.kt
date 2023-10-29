package com.arafat1419.medcheck.ui.features.auth.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arafat1419.medcheck.R
import com.arafat1419.medcheck.ui.theme.GilroyFontFamily
import com.arafat1419.medcheck.ui.theme.ProximaNovaFontFamily
import com.arafat1419.medcheck.ui.theme.Simple
import com.arafat1419.medcheck.ui.theme.Title

@Composable
fun AuthHeader(
    modifier: Modifier = Modifier,
    titleDesc: String
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.SemiBold,
                    )
                ) {
                    append(stringResource(R.string.title_first))
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.ExtraBold,
                    )
                ) {
                    append(stringResource(R.string.title_second))
                }
            },
            style = TextStyle(
                fontSize = 28.sp,
                fontFamily = GilroyFontFamily,
                color = Title
            )
        )
        Text(
            text = titleDesc,
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = ProximaNovaFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Simple
            ),
            modifier = Modifier.padding(top = 4.dp)
        )
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_auth_header),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(start = 64.dp)
                    .requiredWidth(LocalConfiguration.current.screenWidthDp.dp)
            )
        }
    }
}
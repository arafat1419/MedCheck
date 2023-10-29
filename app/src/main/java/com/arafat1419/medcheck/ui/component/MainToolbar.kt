package com.arafat1419.medcheck.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.arafat1419.medcheck.R
import com.arafat1419.medcheck.ui.theme.GreyBorder
import com.arafat1419.medcheck.ui.theme.Red
import com.arafat1419.medcheck.ui.theme.Title

@Composable
fun MainToolbar(
    modifier: Modifier = Modifier,
    onMenuClicked: () -> Unit = {}
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(1F)
        ) {
            IconButton(
                modifier = Modifier
                    .size(28.dp),
                onClick = onMenuClicked,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = null,
                    tint = Title
                )
            }
        }

        IconButton(
            modifier = Modifier
                .padding(end = 32.dp)
                .size(28.dp),
            onClick = { /*TODO*/ },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_cart),
                contentDescription = null,
                tint = Title
            )
        }

        IconButton(
            modifier = Modifier
                .size(28.dp),
            onClick = { /*TODO*/ },
        ) {
            Box {
                Icon(
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = null,
                    tint = Title
                )

                Canvas(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(7.5.dp),
                    onDraw = {
                        val radius = size.width / 2
                        val borderWidth = 1.5.dp.toPx()

                        drawCircle(
                            color = GreyBorder,
                            center = Offset(radius, radius),
                            radius = radius - borderWidth / 2,
                            style = Stroke(width = borderWidth)
                        )

                        drawCircle(
                            color = Red,
                            center = Offset(radius, radius),
                            radius = radius - borderWidth
                        )
                    }
                )
            }
        }
    }
}
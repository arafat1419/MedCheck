package com.arafat1419.medcheck.ui.features.main.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arafat1419.core.domain.model.ProductItemDomain
import com.arafat1419.medcheck.R
import com.arafat1419.medcheck.ui.theme.DarkBlue
import com.arafat1419.medcheck.ui.theme.DarkGreen
import com.arafat1419.medcheck.ui.theme.LightGreen
import com.arafat1419.medcheck.ui.theme.LightGrey
import com.arafat1419.medcheck.ui.theme.Orange
import com.arafat1419.medcheck.ui.theme.ProximaNovaFontFamily
import com.arafat1419.medcheck.utils.ComponentHelper.advancedShadow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListProductContent(
    modifier: Modifier = Modifier,
    products: List<ProductItemDomain>,
    onItemClicked: (value: ProductItemDomain) -> Unit
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        if (products.isEmpty()) {
            item {
                Text(
                    modifier = modifier,
                    text = "Produk tidak ditemukan",
                    fontSize = 14.sp,
                    fontFamily = ProximaNovaFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = DarkBlue
                )
            }
        }

        items(products, key = { it.id }) { value ->
            Card(
                modifier = Modifier
                    .padding(
                        start = if (value == products[0]) 20.dp else 15.dp,
                        end = if (value == products[products.size - 1]) 20.dp else 0.dp
                    )
                    .width(160.dp)
                    .advancedShadow(
                        color = LightGrey,
                        alpha = 0.16F,
                        shadowBlurRadius = 24.dp,
                        offsetY = 16.dp
                    ),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                onClick = { onItemClicked(value) }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Image(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(top = 24.dp),
                        painter = painterResource(id = value.image),
                        contentDescription = null
                    )

                    Row(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(top = 10.dp, end = 10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = value.rating.toString(),
                            fontSize = 16.sp,
                            fontFamily = ProximaNovaFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = LightGrey
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    modifier = Modifier
                        .padding(horizontal = 10.dp),
                    text = value.name,
                    fontSize = 14.sp,
                    fontFamily = ProximaNovaFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = DarkBlue
                )

                Spacer(modifier = Modifier.height(2.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = value.price,
                        fontSize = 12.sp,
                        fontFamily = ProximaNovaFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = Orange
                    )

                    Text(
                        modifier = Modifier
                            .background(LightGreen, RoundedCornerShape(4.dp))
                            .padding(vertical = 6.dp, horizontal = 3.dp),
                        text = if (value.isReady) stringResource(R.string.ready_stock) else stringResource(
                            R.string.empty_stock
                        ),
                        fontSize = 10.sp,
                        fontFamily = ProximaNovaFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = DarkGreen
                    )
                }

                Spacer(modifier = Modifier.height(22.dp))
            }
        }
    }
}
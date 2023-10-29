package com.arafat1419.medcheck.ui.features.main.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arafat1419.core.domain.model.ProductItemDomain
import com.arafat1419.medcheck.R

@Composable
fun ListProduct(
    modifier: Modifier = Modifier
) {
    val filters = listOf("All Product", "Layanan Kesehatan", "Alat Kesehatan")
    var selectedFilter by remember {
        mutableStateOf(filters[0])
    }

    var searchKeyword by remember {
        mutableStateOf("")
    }

    val products = listOf(
        ProductItemDomain(
            1,
            R.drawable.ill_calendar,
            "Suntik Steril A",
            "Rp. 10.000",
            true,
            5F
        ),
        ProductItemDomain(
            2,
            R.drawable.ill_calendar,
            "Suntik Steril B",
            "Rp. 10.000",
            true,
            5F
        ),
        ProductItemDomain(
            3,
            R.drawable.ill_calendar,
            "Suntik Steril C",
            "Rp. 10.000",
            true,
            5F
        ),
        ProductItemDomain(
            4,
            R.drawable.ill_calendar,
            "Suntik Steril D",
            "Rp. 10.000",
            true,
            5F
        ),
    )

    Column(modifier = modifier) {
        ListProductHeader(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = searchKeyword
        ) {
            searchKeyword = it
        }

        ListProductFilters(
            modifier = Modifier
                .padding(top = 40.dp),
            filters = filters,
            selectedFilter = selectedFilter
        ) {
            selectedFilter = it
        }

        ListProductContent(
            modifier = Modifier
                .padding(top = 26.dp),
            products = products.filter {
                it.name.lowercase().contains(searchKeyword.lowercase())
            }
        ) {

        }
    }
}
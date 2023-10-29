package com.arafat1419.core.domain.model

data class ProductItemDomain(
    val id: Int,
    val image: Int,
    val name: String,
    val price: String,
    val isReady: Boolean,
    val rating: Float,
)
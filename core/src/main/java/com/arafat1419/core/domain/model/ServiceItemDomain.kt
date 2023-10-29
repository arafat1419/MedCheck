package com.arafat1419.core.domain.model

data class ServiceItemDomain(
    val id: Int,
    val image: Int,
    val name: String,
    val price: String,
    val address: String,
    val district: String,
    val city: String,
    val type: String
)
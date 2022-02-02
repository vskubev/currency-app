package com.example.currency.model

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyLayerResponse(
    val source: String,
    val quotes: Map<String, Double>
)
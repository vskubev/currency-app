package com.example.currency.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "currency-layer")
data class CurrencyLayerProperties(val apiKey: String)

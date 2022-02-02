package com.example.currency.service

import com.example.currency.model.CurrencyDTO

interface ExchangeRateService {
    fun find(source: String, currencies: List<String>): CurrencyDTO
}
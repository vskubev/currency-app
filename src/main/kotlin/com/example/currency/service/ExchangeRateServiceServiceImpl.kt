package com.example.currency.service

import com.example.currency.client.CurrencyLayerClient
import com.example.currency.mapper.CurrencyMapper
import com.example.currency.model.CurrencyDTO
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class ExchangeRateServiceServiceImpl(
    private val currencyLayerClient: CurrencyLayerClient,
    private val currencyMapper: CurrencyMapper
) : ExchangeRateService {

    @Cacheable("quotes")
    override fun find(source: String, currencies: List<String>): CurrencyDTO {
        val quotes = currencyLayerClient.getExchangeToUSD(source, currencies)
        return currencyMapper.toDTO(quotes)
    }

}
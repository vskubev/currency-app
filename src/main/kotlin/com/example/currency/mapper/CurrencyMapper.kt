package com.example.currency.mapper

import com.example.currency.model.CurrencyDTO
import org.springframework.stereotype.Service

@Service
class CurrencyMapper {

    fun toDTO(currencies: Map<String, Double>) : CurrencyDTO {
        return CurrencyDTO(currencies)
    }
}
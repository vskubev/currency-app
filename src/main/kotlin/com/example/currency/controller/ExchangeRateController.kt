package com.example.currency.controller

import com.example.currency.model.CurrencyDTO
import com.example.currency.service.ExchangeRateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ExchangeRateController @Autowired constructor(
    private val exchangeRateService: ExchangeRateService
) {

    @GetMapping("/exchange")
    fun getExchangeRateToUSD(
        @RequestParam source: String,
        @RequestParam currencies: List<String>
    ): ResponseEntity<CurrencyDTO> {
        return ResponseEntity.ok(exchangeRateService.find(source, currencies))
    }

}
package com.example.currency

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
@ConfigurationPropertiesScan
class CurrencyApplication

fun main(args: Array<String>) {
    runApplication<CurrencyApplication>(*args)
}

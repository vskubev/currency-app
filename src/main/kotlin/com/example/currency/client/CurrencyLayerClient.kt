package com.example.currency.client

import com.beust.klaxon.JsonParsingException
import com.beust.klaxon.Klaxon
import com.example.currency.configuration.CurrencyLayerProperties
import com.example.currency.exception.SystemException
import com.example.currency.model.CurrencyLayerResponse
import khttp.responses.Response
import org.springframework.stereotype.Service
import org.springframework.web.util.UriComponentsBuilder
import java.net.http.HttpRequest


@Service
class CurrencyLayerClient(
    private val httpClient: HttpClient,
    private val currencyLayerProperties: CurrencyLayerProperties
) {

    fun getExchangeToUSD(source: String, currencies: List<String>): Map<String, Double> {
        val currenciesOneLine = currencies.joinToString(separator = ",")

        val uri = UriComponentsBuilder.newInstance()
            .scheme("http")
            .host("apilayer.net")
            .path("api/live")
            .queryParam("access_key", currencyLayerProperties.apiKey)
            .queryParam("currencies", currenciesOneLine)
            .queryParam("source", source)
            .queryParam("format", "1")
            .build()
            .toUri()

        val request = HttpRequest.newBuilder()
            .GET()
            .uri(uri)
            .build()
        val response: Response
        try {
            response = httpClient.send(request)
            val responseBody = Klaxon().parse<CurrencyLayerResponse>(response.jsonObject.toString())
            return responseBody?.quotes ?: throw SystemException(
                "Current exchange rate is not found.\nResponse: $response"
            )
        } catch (e: JsonParsingException) {
            e.printStackTrace()
            throw JsonParsingException("Current exchange rate is not found.\n")
        }
    }
}


package com.example.currency.client

import com.example.currency.exception.SystemException
import khttp.responses.Response
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.net.http.HttpRequest

@Service
class HttpClient {

    private val log: Logger = LoggerFactory.getLogger(HttpClient::class.java)

    fun send(request: HttpRequest): Response {
        log.info("Http request: ${request}")
        val response: Response
        try {
            val url = request.uri().toString()
            response = khttp.request(request.method(), url)
            log.info("Http response: ${response}")
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
        return if (isSuccess(response)) response else
            throw SystemException("Request ${request.uri().path} can't be handled.\nResponse: $response")
    }

    private fun isSuccess(response: Response): Boolean {
        return response.statusCode in 200..299
    }
}
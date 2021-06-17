package com.pedromateus.publisher.infraestrutura.service

import com.pedromateus.publisher.controller.dto.LivroResponse
import com.pedromateus.publisher.infraestrutura.nats.LivroClient
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class NatsService(private val publisher:LivroClient) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    fun sendLivro(livroResponse:LivroResponse){
        logger.info("Enviando $livroResponse")
        publisher.sendLivro(livroResponse)
//        val livroResponse= LivroResponse("titulo","autor")
//        publisher.sendLivroVendas(livroResponse)
//        logger.info("Enviando $livroResponse")
    }

}
package com.pedromateus.livro.service.nats

import com.pedromateus.livro.controller.dto.LivroResponse
import io.micronaut.http.annotation.Body
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject
import org.slf4j.LoggerFactory

@NatsListener
class RecebendoLivroNats{
    private val logger= LoggerFactory.getLogger(this::class.java)
    @Subject("livro")
    fun recebeRequisicao(@Body livro: LivroResponse){
        logger.info("recebendo do nats $livro")
    }
}
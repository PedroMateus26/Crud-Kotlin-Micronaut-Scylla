package com.pedromateus.livro.controller

import com.pedromateus.livro.controller.dto.LivroRequest
import com.pedromateus.livro.controller.dto.LivroResponse
import com.pedromateus.livro.service.LivroService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject
import org.slf4j.LoggerFactory

@NatsListener
class LivroController(
    private val livroService: LivroService,
    ) {

    private val logger= LoggerFactory.getLogger(this::class.java)

    @Subject("livro.estoque.reposicao")
    fun salvaLivro(@Body livroRequest: LivroRequest) {
        logger.info("Recebendo $livroRequest do publisher")
        livroService.salvaLivro(livroRequest)
    }
}



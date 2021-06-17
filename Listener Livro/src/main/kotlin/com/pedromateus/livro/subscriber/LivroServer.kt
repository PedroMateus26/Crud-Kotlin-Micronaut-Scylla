package com.pedromateus.livro.subscriber

import com.pedromateus.livro.controller.dto.LivroRequest
import com.pedromateus.livro.service.LivroService
import io.micronaut.http.annotation.Body
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject
import org.slf4j.LoggerFactory

@NatsListener
class LivroServer(
    private val livroService: LivroService,
    ) {

    private val logger= LoggerFactory.getLogger(this::class.java)

    @Subject("livro.estoque.*")
    fun salvaLivro(@Body livroRequest: LivroRequest) {
        logger.info("Recebendo $livroRequest do publisher")
        livroService.salvaLivro(livroRequest)
    }


}



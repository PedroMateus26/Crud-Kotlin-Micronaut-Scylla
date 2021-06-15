package com.pedromateus.livro.controller

import com.pedromateus.livro.controller.dto.LivroRequest
import com.pedromateus.livro.controller.dto.LivroResponse
import com.pedromateus.livro.service.LivroService
import com.pedromateus.livro.service.nats.RequestNats
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.nats.annotation.NatsConnection
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject
import io.nats.client.Nats
import org.slf4j.LoggerFactory

@Controller("/livros")
class LivroController(
    private val livroService: LivroService,
    private val natsRequest: RequestNats
    ) {

    private val logger=LoggerFactory.getLogger(this::class.java)

    @Post
    fun salvaLivro(@Body livroRequest: LivroRequest): HttpResponse<LivroResponse> {
        val livroResponse=livroService.salvaLivro(livroRequest)
        logger.info("Enviando $livroResponse para container do nats")
        natsRequest.livroTituloRequest(livroResponse=livroResponse)
        return HttpResponse.ok(livroResponse)
    }
}



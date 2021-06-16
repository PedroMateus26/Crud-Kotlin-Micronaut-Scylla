package com.pedromateus.publisher.service.nats

import com.pedromateus.publisher.controller.LivroResponse
import io.micronaut.http.annotation.Body
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface PublisherDeLivros {

    @Subject("livro.estoque.reposicao",)
    fun livroRequest(@Body livroResponse: LivroResponse)
}

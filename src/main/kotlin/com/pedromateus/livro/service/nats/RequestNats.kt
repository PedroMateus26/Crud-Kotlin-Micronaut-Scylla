package com.pedromateus.livro.service.nats

import com.pedromateus.livro.controller.dto.LivroResponse
import io.micronaut.http.annotation.Body
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface RequestNats {

    @Subject("livro",)
    fun livroTituloRequest(@Body livroResponse: LivroResponse)
}
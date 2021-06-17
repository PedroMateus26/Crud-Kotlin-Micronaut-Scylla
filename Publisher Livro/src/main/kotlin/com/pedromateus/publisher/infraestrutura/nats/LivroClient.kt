package com.pedromateus.publisher.infraestrutura.nats

import com.pedromateus.publisher.controller.dto.LivroResponse
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface LivroClient {

    @Subject("livro.estoque.reposicao",)
    fun sendLivro(livroResponse: LivroResponse)

    @Subject("livro.estoque.vendas")
    fun sendLivroVendas(livroRequest: LivroResponse)

}

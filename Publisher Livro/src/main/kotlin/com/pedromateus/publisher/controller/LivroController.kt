package com.pedromateus.publisher.controller

import com.pedromateus.publisher.service.nats.PublisherDeLivros
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/livros")
class LivroController (private val publisher:PublisherDeLivros){

    @Post
    fun novosLivros(@Body livroRequest: LivroResponse){
        publisher.livroRequest(livroRequest)
    }
}
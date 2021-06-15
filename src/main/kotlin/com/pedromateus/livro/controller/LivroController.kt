package com.pedromateus.livro.controller

import com.pedromateus.livro.controller.dto.LivroRequest
import com.pedromateus.livro.controller.dto.LivroResponse
import com.pedromateus.livro.service.LivroService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/livros")
class LivroController(private val livroService: LivroService) {

    @Post
    fun salvaLivro(@Body livroRequest: LivroRequest): HttpResponse<LivroResponse> {
        val livroResponse=livroService.salvaLivro(livroRequest)
        return HttpResponse.ok(livroResponse)
    }
}
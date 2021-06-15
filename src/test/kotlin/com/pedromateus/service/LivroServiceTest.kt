package com.pedromateus.service

import com.pedromateus.livro.controller.LivroRequest
import com.pedromateus.livro.controller.LivroResponse
import com.pedromateus.livro.repository.LivroRepository
import com.pedromateus.livro.service.LivroService
import com.pedromateus.livro.service.LivroServiceimpl
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify


@MicronautTest
class LivroServiceTest: AnnotationSpec() {

    val repository= mockk<LivroRepository>()
    val service=LivroServiceimpl(repository)

    @Test
    fun `deve salvar um livro no banco de dados`(){
        val request= LivroRequest(titulo = "titulo",autor = "autor")
        val livro=request.paraLivro()
        val response= LivroResponse(titulo=livro.titulo,autor=livro.autor)

        every { repository.salvaLivro(livro) } answers {livro}
        val result = service.salvaLivro(livroRequest = request)

        verify { repository.salvaLivro(any()) }

        with(result){
            autor shouldBe response.autor
            titulo shouldBe response.titulo
        }
    }

}
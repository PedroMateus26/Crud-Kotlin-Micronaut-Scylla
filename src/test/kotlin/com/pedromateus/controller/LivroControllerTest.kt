package com.pedromateus.controller

import com.pedromateus.livro.controller.LivroController
import com.pedromateus.livro.controller.LivroRequest
import com.pedromateus.livro.controller.LivroResponse
import com.pedromateus.livro.service.LivroService
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

@MicronautTest
class LivroControllerTest:AnnotationSpec() {

    val service= mockk<LivroService>()
    val controller= LivroController(service)

    @Test
    fun `deve cadastrar um livro`(){
        val request= LivroRequest(titulo = "titulo",autor = "autor")
        val livro=request.paraLivro()
        val response= LivroResponse(titulo=livro.titulo,autor=livro.autor)

        every { service.salvaLivro(any()) } answers { response}
        val result = controller.salvaLivro(livroRequest = request)


        verify { service.salvaLivro(any()) }
        with(result){
            status shouldBe HttpStatus.OK
            body() shouldBe response
        }

    }
}
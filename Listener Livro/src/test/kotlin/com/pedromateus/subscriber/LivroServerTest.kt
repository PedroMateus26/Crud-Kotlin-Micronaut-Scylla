package com.pedromateus.subscriber

import com.pedromateus.livro.subscriber.LivroServer
import com.pedromateus.livro.controller.dto.LivroRequest
import com.pedromateus.livro.controller.dto.LivroResponse
import com.pedromateus.livro.entity.LivroEntity
import com.pedromateus.livro.service.LivroServiceimpl
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk

@MicronautTest
class LivroServerTest:AnnotationSpec() {

    val service= mockk<LivroServiceimpl>()
    val controller= LivroServer(service)

    lateinit var request: LivroRequest
    lateinit var livro:LivroEntity
    lateinit var response: LivroResponse

    @BeforeEach
    fun setUp(){
        request= LivroRequest(titulo = "titulo",autor = "autor")
        livro=request.paraLivro()
        response= LivroResponse(titulo=livro.titulo,autor=livro.autor)
    }

    @Test
    fun `deve cadastrar um livro`(){

        every { service.salvaLivro(any()) } answers { response}
        val result=controller.salvaLivro(livroRequest = request)

        result shouldBe Unit
    }
}
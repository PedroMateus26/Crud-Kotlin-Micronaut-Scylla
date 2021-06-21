package com.pedromateus.service

import com.pedromateus.livro.repository.LivroRepository
import com.pedromateus.livro.service.LivroServiceimpl
import com.pedromateus.livro.subscriber.model.LivroRequest
import io.kotest.core.spec.style.AnnotationSpec
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk


@MicronautTest
class LivroServiceTest: AnnotationSpec() {

    val repository= mockk<LivroRepository>()
    val service=LivroServiceimpl(repository)

    @Test
    fun `deve salvar um livro no banco de dados`(){
        val request= LivroRequest(titulo = "titulo",autor = "autor")

        every { repository.salvaLivro(request) } answers {request}
        service.salvaLivro(livroRequest = request)

    }

}
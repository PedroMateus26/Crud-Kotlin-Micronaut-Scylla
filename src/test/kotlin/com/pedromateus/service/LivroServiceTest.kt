package com.pedromateus.service

import com.pedromateus.livro.core.ports.LivroRepositoryPort
import com.pedromateus.livro.core.service.LivroServiceimplPort
import com.pedromateus.livro.infrastructure.model.LivroRequestDTO
import io.kotest.core.spec.style.AnnotationSpec
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*


@MicronautTest
class LivroServiceTest: AnnotationSpec() {

    val repository= mockk<LivroRepositoryPort>()
    val service= LivroServiceimplPort(repository)

    @Test
    fun `deve salvar um livro no banco de dados`(){
        val request= LivroRequestDTO(titulo = "titulo",autor = "autor")

        every { repository.salvaLivro(any()) } answers {request}
        service.salvaLivro(livroRequestDTO = request)

    }

    @Test
    fun `deve atualizar um livro no banco de dados`(){
        val request= LivroRequestDTO(titulo = "titulo",autor = "autor")

        every { repository.atualizaLivro(any(),any()) } answers {request}
        service.atualizaLivro(livroRequestDTO = request,UUID.randomUUID())

    }

    @Test
    fun `deve deletar um livro no banco de dados`(){
        val request= LivroRequestDTO(titulo = "titulo",autor = "autor")

        every { repository.deletaLivro(any()) } answers {request}
        service.deletaLivro(UUID.randomUUID())

    }

}
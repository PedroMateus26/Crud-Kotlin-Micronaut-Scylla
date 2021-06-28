package com.pedromateus.service

import com.pedromateus.livro.core.model.Livro
import com.pedromateus.livro.core.ports.LivroRepositoryPort
import com.pedromateus.livro.core.service.LivroServiceimplPort
import com.pedromateus.livro.database.entity.LivroEntity
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*


@MicronautTest
class LivroServiceTest: AnnotationSpec() {

    val repository= mockk<LivroRepositoryPort>()
    val service= LivroServiceimplPort(repository)

    lateinit var livroSalvar: Livro
    lateinit var livroAtualizar: Livro
    lateinit var livroDeletar: Livro

    @BeforeEach
    fun setUp(){
        livroSalvar= Livro(null,titulo = "titulo",autor = "autor")
        livroAtualizar= Livro(UUID.randomUUID(),titulo = "titulo",autor = "autor")
        livroDeletar= Livro(UUID.randomUUID(),null,null)
    }

    @Test
    fun `deve salvar um livro no banco de dados`(){
        every { repository.salvaLivro(any()) } answers {}
        val result = service.salvaLivro(livroSalvar)

        result shouldBe Unit

    }

    @Test
    fun `deve atualizar um livro no banco de dados`(){

        every { repository.atualizaLivro(any()) } answers {Unit}
        service.atualizaLivro(livroAtualizar)

    }

    @Test
    fun `deve deletar um livro no banco de dados`(){
        every { repository.deletaLivro(any()) } answers {Unit}
        service.deletaLivro(livroDeletar)

    }

}
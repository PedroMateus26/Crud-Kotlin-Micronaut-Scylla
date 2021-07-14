package com.pedromateus.repository

import com.pedromateus.livro.database.entity.LivroEntity
import com.pedromateus.livro.database.repository.LivroRepository
import com.pedromateus.livro.database.repository.LivroRespositoryImpl
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class LivroRepositoryTest:AnnotationSpec() {

    val livroRepository= mockk<LivroRepository>(relaxed = true)
    var livroRespositoryImpl= LivroRespositoryImpl(livroRepository)

    lateinit var livroEntitySalvar:LivroEntity
    lateinit var livroEntityAtualizar:LivroEntity
    lateinit var livroEntityDeletar:LivroEntity


    @BeforeEach
    fun setUp() {
        livroEntitySalvar=LivroEntity(null,"titulo","autor")
        livroEntityAtualizar=LivroEntity(UUID.randomUUID(),"titulo","autor")
        livroEntityDeletar=LivroEntity(UUID.randomUUID(),null,null)

    }

    @Test
    fun `deve salvar na base de dados`(){
         every { }answers {livroEntitySalvar}

        val result  = livroRespositoryImpl.salvaLivro(livroEntitySalvar)
        result shouldBe Unit
    }

    @Test
    fun `deve atualizar na base de dados`(){

        every { }answers {livroEntityAtualizar}

        val result  = livroRespositoryImpl.atualizaLivro(livroEntityAtualizar)
        result shouldBe Unit
    }

    @Test
    fun `deve deletar na base de dados`(){


        val result  = livroRespositoryImpl.deletaLivro(livroEntityDeletar)
        result shouldBe Unit
    }



}
package com.pedromateus.repository

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.ResultSet
import com.datastax.oss.driver.api.core.cql.Row
import com.datastax.oss.driver.api.querybuilder.QueryBuilder
import com.pedromateus.livro.database.entity.LivroEntity
import com.pedromateus.livro.database.repository.LivroRespositoryImpl
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.UUID

@MicronautTest
class LivroRepositoryTest:AnnotationSpec() {

    val cqlSession= mockk<CqlSession>(relaxed = true)
    var livroRespositoryImpl= LivroRespositoryImpl(cqlSession)

    lateinit var livroEntitySalvar:LivroEntity
    lateinit var livroEntityAtualizar:LivroEntity
    lateinit var livroEntityDeletar:LivroEntity
    lateinit var resultSet: ResultSet


    @BeforeEach
    fun setUp() {
        livroEntitySalvar=LivroEntity(null,"titulo","autor")
        livroEntityAtualizar=LivroEntity(UUID.randomUUID(),"titulo","autor")
        livroEntityDeletar=LivroEntity(UUID.randomUUID(),null,null)

    }

    @Test
    fun `deve salvar na base de dados`(){
         every { cqlSession.execute("") }answers {resultSet}
        val result  = livroRespositoryImpl.salvaLivro(livroEntitySalvar)
        result shouldBe Unit
    }

    @Test
    fun `deve atualizar na base de dados`(){
        every { cqlSession.execute("") }answers {resultSet}
        val result  = livroRespositoryImpl.atualizaLivro(livroEntityAtualizar)
        result shouldBe Unit
    }

    @Test
    fun `deve deletar na base de dados`(){
        every { cqlSession.execute("") }answers {resultSet}
        val result  = livroRespositoryImpl.deletaLivro(livroEntityDeletar)
        result shouldBe Unit
    }



}
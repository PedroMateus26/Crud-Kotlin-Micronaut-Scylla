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
    lateinit var row: Row

    @BeforeEach
    fun setUp() {
        livroEntitySalvar=LivroEntity(null,"titulo","autor")
        livroEntityAtualizar=LivroEntity(UUID.randomUUID(),"titulo","autor")
        livroEntityDeletar=LivroEntity(UUID.randomUUID(),null,null)

    }

    @Test
    fun `deve salvar na base de dados`(){
         every { cqlSession.execute(
             QueryBuilder.insertInto("prateleira")
                 .value("id", QueryBuilder.literal(UUID.randomUUID()))
                 .value("titulo", QueryBuilder.literal(livroEntitySalvar.titulo))
                 .value("autor", QueryBuilder.literal(livroEntitySalvar.autor))
                 .build()
         ).map { LivroEntity(
             id=it.getUuid("id"),
             titulo = it.getString("titulo"),autor = it.getString("autor")
         ) }.one() }answers {livroEntitySalvar}

        val result  = livroRespositoryImpl.salvaLivro(livroEntitySalvar)
        result shouldBe Unit
    }

    @Test
    fun `deve atualizar na base de dados`(){

        every { cqlSession.execute(
            QueryBuilder.update("prateleira")
            .setColumn("titulo", QueryBuilder.literal(livroEntityAtualizar.titulo))
            .setColumn("autor", QueryBuilder.literal(livroEntityAtualizar.autor))
            .whereColumn("id")
            .isEqualTo(QueryBuilder.literal(livroEntityAtualizar.id))
            .build()).map { LivroEntity(
            id=it.getUuid("id"),
            titulo = it.getString("titulo"),autor = it.getString("autor")
        ) }.firstOrNull() }answers {livroEntityAtualizar}

        val result  = livroRespositoryImpl.atualizaLivro(livroEntityAtualizar)
        result shouldBe Unit
    }

    @Test
    fun `deve deletar na base de dados`(){

         cqlSession.execute(
            QueryBuilder.deleteFrom("prateleira")
                .whereColumn("id")
                .isEqualTo(QueryBuilder.literal(livroEntityDeletar.id))
                .ifExists()
                .build()
        )
        val result  = livroRespositoryImpl.deletaLivro(livroEntityDeletar)
        result shouldBe Unit
    }



}
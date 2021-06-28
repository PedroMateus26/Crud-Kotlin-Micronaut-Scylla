package com.pedromateus.repository

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.querybuilder.QueryBuilder
import com.pedromateus.livro.database.entity.LivroEntity
import com.pedromateus.livro.database.repository.LivroRespositoryImplPort
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.core.spec.style.AnnotationSpec.*
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import java.util.UUID

@MicronautTest
@ExtendWith(MockKExtension::class)
class LivroRepositoryTest:AnnotationSpec() {

    @InjectMockKs
    lateinit var livroRespositoryImplPort: LivroRespositoryImplPort

    @RelaxedMockK
    lateinit var cqlSession: CqlSession

    lateinit var livroEntitySalvar:LivroEntity
    lateinit var livroEntityAtualizar:LivroEntity
    lateinit var livroEntityDeletar:LivroEntity

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        livroEntitySalvar=LivroEntity(null,"titulo","autor")
        livroEntityAtualizar=LivroEntity(UUID.randomUUID(),"titulo","autor")
        livroEntityDeletar=LivroEntity(UUID.randomUUID(),null,null)
    }

    @Test
    fun `deve salvar na base de dados`(){
        cqlSession.execute(
            QueryBuilder.insertInto("prateleira")
                .value("id", QueryBuilder.literal(UUID.randomUUID()))
                .value("titulo", QueryBuilder.literal(livroEntitySalvar.titulo))
                .value("autor", QueryBuilder.literal(livroEntitySalvar.autor))
                .build()
        )

        val result  = livroRespositoryImplPort.salvaLivro(livroEntitySalvar)
        assertEquals(result,Unit)
    }

    @Test
    fun `deve atualizar na base de dados`(){
        cqlSession.execute(
            QueryBuilder.insertInto("prateleira")
                .value("id", QueryBuilder.literal(UUID.randomUUID()))
                .value("titulo", QueryBuilder.literal(livroEntityAtualizar.titulo))
                .value("autor", QueryBuilder.literal(livroEntityAtualizar.autor))
                .build()
        )

        val result  = livroRespositoryImplPort.salvaLivro(livroEntityAtualizar)
        assertEquals(result,Unit)
    }

    @Test
    fun `deve deletar na base de dados`(){
        cqlSession.execute(
            QueryBuilder.insertInto("prateleira")
                .value("id", QueryBuilder.literal(UUID.randomUUID()))
                .value("titulo", QueryBuilder.literal(livroEntityDeletar.titulo))
                .value("autor", QueryBuilder.literal(livroEntityDeletar.autor))
                .build()
        )

        val result  = livroRespositoryImplPort.salvaLivro(livroEntityDeletar)
        assertEquals(result,Unit)
    }


}
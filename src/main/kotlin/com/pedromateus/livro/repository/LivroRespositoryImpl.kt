package com.pedromateus.livro.repository

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import com.pedromateus.livro.subscriber.model.LivroRequest
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroRespositoryImpl(private val cqlSession:CqlSession):LivroRepository {
    override fun salvaLivro(livroEntity: LivroRequest) {
        cqlSession.execute(
            SimpleStatement.newInstance(
                "INSERT INTO estoque.prateleira(id, titulo, autor) values (?,?,?)",
                UUID.randomUUID(),
                livroEntity.titulo,
                livroEntity.autor
            )
        )
    }
}
package com.pedromateus.livro.repository

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import com.datastax.oss.driver.api.core.cql.SimpleStatementBuilder
import com.pedromateus.livro.entity.LivroEntity
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroRespositoryImpl(private val cqlSession:CqlSession):LivroRepository {
    override fun salvaLivro(livroEntity: LivroEntity): LivroEntity {
        cqlSession.execute(
            SimpleStatement.newInstance(
                "INSERT INTO estoque.prateleira(id, titulo, autor) values (?,?,?)",
                UUID.randomUUID(),
                livroEntity.titulo,
                livroEntity.autor
            )
        )
        return livroEntity
    }


}
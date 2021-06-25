package com.pedromateus.livro.database.repository

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.Row
import com.datastax.oss.driver.api.querybuilder.QueryBuilder.*
import com.pedromateus.livro.core.ports.LivroRepositoryPort
import com.pedromateus.livro.database.entity.LivroEntity
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroRespositoryImplPort(private val cqlSession: CqlSession) : LivroRepositoryPort {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun salvaLivro(livroEntity: LivroEntity) {
        cqlSession.execute(
            insertInto("prateleira")
                .value("id", literal(UUID.randomUUID()))
                .value("titulo", literal(livroEntity.titulo))
                .value("autor", literal(livroEntity.autor))
                .build()
        )
        logger.info("livro salvo")
    }

    override fun atualizaLivro(livroEntity: LivroEntity) {
        val value = findById(livroEntity.id)
        if (value != null) {
            cqlSession.execute(update("prateleira")
                .setColumn("titulo", literal(livroEntity.titulo))
                .setColumn("autor", literal(livroEntity.autor))
                .whereColumn("id")
                .isEqualTo(literal(livroEntity.id))
                .build())
        }
    }

    override fun deletaLivro(livroEntity:LivroEntity) {
        val teste = findById(livroEntity.id)
        cqlSession.execute(
            deleteFrom("prateleira")
                .whereColumn("id")
                .isEqualTo(literal(livroEntity.id))
                .ifExists()
                .build()
        )
        logger.info("livro deletado")
    }

    private fun findById(id:UUID?) = converteRowParaLivroEvent(
        cqlSession.execute(
            selectFrom("prateleira")
                .all()
                .whereColumn("id")
                .isEqualTo(literal(id))
                .build()
        ).one()!!
    )

    private fun converteRowParaLivroEvent(row:Row)= LivroEntity(
        id=row.getUuid("id"),
        titulo = row.getString("titulo"),autor = row.getString("autor")
    )


}
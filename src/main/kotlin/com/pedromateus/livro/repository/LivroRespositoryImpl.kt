package com.pedromateus.livro.repository

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.Row
import com.datastax.oss.driver.api.querybuilder.QueryBuilder.*
import com.pedromateus.livro.subscriber.model.LivroEvent
import com.pedromateus.livro.subscriber.model.LivroRequest
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroRespositoryImpl(private val cqlSession: CqlSession) : LivroRepository {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun salvaLivro(livro: LivroRequest) {
        cqlSession.execute(
            insertInto("prateleira")
                .value("id", literal(UUID.randomUUID()))
                .value("titulo", literal(livro.titulo))
                .value("autor", literal(livro.autor))
                .build()
        )
        logger.info("livro salvo")
    }

    override fun atualizaLivro(livro: LivroRequest,id:UUID) {
        val value = findById(id)
        if (value != null) {
            cqlSession.execute(update("prateleira")
                .setColumn("titulo", literal(livro.titulo))
                .setColumn("autor", literal(livro.autor))
                .whereColumn("id")
                .isEqualTo(literal(id))
                .build())
        }
    }

    override fun deletaLivro(id: UUID) {
        val teste = findById(id)
        cqlSession.execute(
            deleteFrom("prateleira")
                .whereColumn("id")
                .isEqualTo(literal(id))
                .ifExists()
                .build()
        )
        logger.info("livro deletado")
    }

    private fun findById(id: UUID) = converteRowParaLivroEvent(
        cqlSession.execute(
            selectFrom("prateleira")
                .all()
                .whereColumn("id")
                .isEqualTo(literal(id))
                .build()
        ).one()!!
    )

    private fun converteRowParaLivroEvent(row:Row)=LivroEvent(
        id=row.getUuid("id"),
        LivroRequest(titulo = row.getString("titulo")!!,autor = row.getString("autor")!!)
    )

}
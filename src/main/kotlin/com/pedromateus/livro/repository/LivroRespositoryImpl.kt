package com.pedromateus.livro.repository

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.Row
import com.datastax.oss.driver.api.querybuilder.QueryBuilder.*
import com.pedromateus.livro.subscriber.model.LivroEvent
import com.pedromateus.livro.subscriber.model.LivroRequestDTO
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroRespositoryImpl(private val cqlSession: CqlSession) : LivroRepository {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun salvaLivro(livroDTO: LivroRequestDTO) {
        cqlSession.execute(
            insertInto("prateleira")
                .value("id", literal(UUID.randomUUID()))
                .value("titulo", literal(livroDTO.titulo))
                .value("autor", literal(livroDTO.autor))
                .build()
        )
        logger.info("livro salvo")
    }

    override fun atualizaLivro(livroDTO: LivroRequestDTO, id:UUID) {
        val value = findById(id)
        if (value != null) {
            cqlSession.execute(update("prateleira")
                .setColumn("titulo", literal(livroDTO.titulo))
                .setColumn("autor", literal(livroDTO.autor))
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
        LivroRequestDTO(titulo = row.getString("titulo")!!,autor = row.getString("autor")!!)
    )

}
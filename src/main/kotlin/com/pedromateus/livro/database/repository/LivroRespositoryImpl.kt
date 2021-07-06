package com.pedromateus.livro.database.repository

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.querybuilder.QueryBuilder.*
import com.pedromateus.livro.core.ports.LivroRepositoryPort
import com.pedromateus.livro.database.entity.LivroEntity
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroRespositoryImpl(private val cqlSession: CqlSession) : LivroRepositoryPort {

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

        cqlSession.execute(
            update("prateleira")
                .setColumn("titulo", literal(livroEntity.titulo))
                .setColumn("autor", literal(livroEntity.autor))
                .whereColumn("id")
                .isEqualTo(literal(livroEntity.id))
                .ifExists()
                .build()
        )
        logger.info("livro atualizado")
    }


    override fun deletaLivro(livroEntity: LivroEntity) {

        cqlSession.execute(
            deleteFrom("prateleira")
                .whereColumn("id")
                .isEqualTo(literal(livroEntity.id))
                .ifExists()
                .build()
        )

        logger.info("livro deletado")
    }


}
package com.pedromateus.livro.database.repository

import com.pedromateus.livro.core.ports.LivroRepositoryPort
import com.pedromateus.livro.database.entity.LivroEntity
import org.slf4j.LoggerFactory
import javax.inject.Singleton
import javax.persistence.EntityNotFoundException

@Singleton
class LivroRespositoryImpl(private val repository: LivroRepository) : LivroRepositoryPort {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun salvaLivro(livroEntity: LivroEntity) {
        logger.info("Salvando Livro")
        repository.save(livroEntity)
        logger.info("Livro Salvo")
    }

    override fun atualizaLivro(livroEntity: LivroEntity) {
        logger.info("Atualizando Livro")
        repository.findById(livroEntity.id).orElseThrow {
            logger.info("Id ${livroEntity.id} não encontrado")
            throw EntityNotFoundException("Entidade não encontrada.")
        }
        repository.update(livroEntity)
        logger.info("Livro Atualizado")
    }


    override fun deletaLivro(livroEntity: LivroEntity) {
        logger.info("Deletando Livro")
        val livroDelete=repository.findById(livroEntity.id).orElseThrow {
            logger.info("Id ${livroEntity.id} não encontrado")
            throw EntityNotFoundException("Entidade não encontrada.")
        }
        repository.delete(livroDelete)
        logger.info("Livro Deletado")
    }


}
package com.pedromateus.livro.core.ports

import com.pedromateus.livro.core.model.LivroEntity
import com.pedromateus.livro.infrastructure.model.LivroRequestDTO
import java.util.*

interface LivroRepository {
    fun salvaLivro(livroEntity: LivroEntity)
    fun atualizaLivro(livroEntity: LivroEntity, id: UUID)
    fun deletaLivro(id: UUID)
}
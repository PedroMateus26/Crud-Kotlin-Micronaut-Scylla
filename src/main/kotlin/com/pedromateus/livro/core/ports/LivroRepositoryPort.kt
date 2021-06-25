package com.pedromateus.livro.core.ports

import com.pedromateus.livro.database.entity.LivroEntity
import java.util.*

interface LivroRepositoryPort {
    fun salvaLivro(livroEntity: LivroEntity)
    fun atualizaLivro(livroEntity: LivroEntity)
    fun deletaLivro(livroEntity: LivroEntity)
}
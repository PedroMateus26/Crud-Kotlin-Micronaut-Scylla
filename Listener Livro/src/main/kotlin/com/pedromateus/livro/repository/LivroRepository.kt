package com.pedromateus.livro.repository

import com.pedromateus.livro.entity.LivroEntity

interface LivroRepository {
    fun salvaLivro(livroEntity: LivroEntity):LivroEntity
}
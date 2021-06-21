package com.pedromateus.livro.repository

import com.pedromateus.livro.subscriber.model.LivroRequest

interface LivroRepository {
    fun salvaLivro(livroRequest: LivroRequest)
}
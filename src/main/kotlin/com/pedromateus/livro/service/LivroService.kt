package com.pedromateus.livro.service

import com.pedromateus.livro.subscriber.model.LivroRequest

interface LivroService {
    fun salvaLivro(livroRequest: LivroRequest)
}
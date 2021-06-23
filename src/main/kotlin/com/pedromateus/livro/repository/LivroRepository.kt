package com.pedromateus.livro.repository

import com.pedromateus.livro.subscriber.model.LivroRequest
import java.util.*

interface LivroRepository {
    fun salvaLivro(livroRequest: LivroRequest)
    fun atualizaLivro(livroRequest: LivroRequest,id: UUID)
    fun deletaLivro(id: UUID)
}
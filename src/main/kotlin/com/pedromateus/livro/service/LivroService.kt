package com.pedromateus.livro.service

import com.pedromateus.livro.subscriber.model.LivroRequest
import java.util.*

interface LivroService {
    fun salvaLivro(livroRequest: LivroRequest)
    fun atualizaLivro(livroRequest: LivroRequest,id: UUID)
    fun deletaLivro(id: UUID)
}
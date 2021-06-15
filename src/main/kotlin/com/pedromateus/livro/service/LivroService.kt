package com.pedromateus.livro.service

import com.pedromateus.livro.controller.LivroRequest
import com.pedromateus.livro.controller.LivroResponse

interface LivroService {
    fun salvaLivro(livroRequest: LivroRequest):LivroResponse
}
package com.pedromateus.livro.service

import com.pedromateus.livro.controller.dto.LivroRequest
import com.pedromateus.livro.controller.dto.LivroResponse

interface LivroService {
    fun salvaLivro(livroRequest: LivroRequest): LivroResponse
}
package com.pedromateus.livro.service

import com.pedromateus.livro.controller.dto.LivroRequest
import com.pedromateus.livro.controller.dto.LivroResponse
import com.pedromateus.livro.repository.LivroRepository
import javax.inject.Singleton

@Singleton
class LivroServiceimpl(private val livroRepository: LivroRepository):LivroService {

    override fun salvaLivro(livroRequest: LivroRequest): LivroResponse {
        val livro=livroRepository.salvaLivro(livroRequest.paraLivro())
        return LivroResponse(livro.titulo,livro.autor)
    }

}

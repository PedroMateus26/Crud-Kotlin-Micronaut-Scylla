package com.pedromateus.livro.service

import com.pedromateus.livro.subscriber.model.LivroRequestDTO
import java.util.*

interface LivroService {
    fun salvaLivro(livroRequestDTO: LivroRequestDTO)
    fun atualizaLivro(livroRequestDTO: LivroRequestDTO, id: UUID)
    fun deletaLivro(id: UUID)
}
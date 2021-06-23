package com.pedromateus.livro.repository

import com.pedromateus.livro.subscriber.model.LivroRequestDTO
import java.util.*

interface LivroRepository {
    fun salvaLivro(livroRequestDTO: LivroRequestDTO)
    fun atualizaLivro(livroRequestDTO: LivroRequestDTO, id: UUID)
    fun deletaLivro(id: UUID)
}
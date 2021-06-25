package com.pedromateus.livro.core.ports

import com.pedromateus.livro.infrastructure.model.LivroRequestDTO
import java.util.*

interface LivroService {
    fun salvaLivro(livroRequestDTO: LivroRequestDTO)
    fun atualizaLivro(livroRequestDTO: LivroRequestDTO, id: UUID)
    fun deletaLivro(id: UUID)
}
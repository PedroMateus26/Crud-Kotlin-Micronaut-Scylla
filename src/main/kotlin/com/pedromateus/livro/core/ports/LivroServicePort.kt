package com.pedromateus.livro.core.ports

import com.pedromateus.livro.core.model.Livro

interface LivroServicePort {
    fun salvaLivro(livro:Livro)
    fun atualizaLivro(livro:Livro)
    fun deletaLivro(livro:Livro)
}
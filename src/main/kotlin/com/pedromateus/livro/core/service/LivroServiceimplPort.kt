package com.pedromateus.livro.core.service

import com.pedromateus.livro.core.mappers.LivroConverter
import com.pedromateus.livro.core.model.Livro
import com.pedromateus.livro.core.ports.LivroRepositoryPort
import com.pedromateus.livro.core.ports.LivroServicePort
import javax.inject.Singleton

@Singleton
class LivroServiceimplPort(private val livroRepositoryPort: LivroRepositoryPort): LivroServicePort {
    override fun salvaLivro(livro: Livro) {
        val livroEntity=LivroConverter.converteLivroParaLivroEntity(livro)
        livroRepositoryPort.salvaLivro(livroEntity)
    }

    override fun atualizaLivro(livro: Livro) {
        val livroEntity=LivroConverter.converteLivroParaLivroEntity(livro)
        livroRepositoryPort.atualizaLivro(livroEntity)
    }

    override fun deletaLivro(livro: Livro) {
        val livroEntity=LivroConverter.converteLivroParaLivroEntity(livro)
        livroRepositoryPort.deletaLivro(livroEntity)
    }


}

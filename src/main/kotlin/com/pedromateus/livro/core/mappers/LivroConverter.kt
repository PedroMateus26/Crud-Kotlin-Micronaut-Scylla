package com.pedromateus.livro.core.mappers

import com.pedromateus.livro.core.model.Livro
import com.pedromateus.livro.database.entity.LivroEntity
import com.pedromateus.livro.infrastructure.model.LivroEvent

class LivroConverter{
    companion object{
        fun converteLivroEventParaLivro(livroEvent: LivroEvent)= Livro(livroEvent.id,livroEvent.titulo,livroEvent.autor)
        fun converteLivroParaLivroEntity(livro: Livro)= LivroEntity(livro.id,livro.titulo,livro.autor)

    }

}
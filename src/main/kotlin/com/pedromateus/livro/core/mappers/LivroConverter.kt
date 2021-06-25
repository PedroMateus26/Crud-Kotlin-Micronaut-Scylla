package com.pedromateus.livro.core.mappers

import com.pedromateus.livro.core.model.LivroEntity
import com.pedromateus.livro.infrastructure.model.LivroRequestDTO

class LivroConverter{
    companion object{
        fun entityParaDtoDeSaida(livroEntity: LivroEntity)=LivroRequestDTO(livroEntity.titulo,livroEntity.autor)
        fun dtoParaEntity(livroRequestDTO: LivroRequestDTO)=LivroEntity(livroRequestDTO.titulo,livroRequestDTO.autor)

    }

}
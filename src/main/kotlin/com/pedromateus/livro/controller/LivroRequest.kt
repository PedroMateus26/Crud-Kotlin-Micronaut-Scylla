package com.pedromateus.livro.controller

import com.pedromateus.livro.entity.LivroEntity
import io.micronaut.core.annotation.Introspected

@Introspected
data class LivroRequest(
    val titulo: String,
    val autor: String
){
    fun paraLivro()=LivroEntity(titulo=titulo,autor=autor)
}
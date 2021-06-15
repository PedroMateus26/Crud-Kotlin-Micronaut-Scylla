package com.pedromateus.livro.entity

import io.micronaut.core.annotation.Introspected

@Introspected
data class LivroEntity(
    val autor: String,
    val titulo: String
)
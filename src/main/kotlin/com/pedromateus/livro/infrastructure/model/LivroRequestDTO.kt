package com.pedromateus.livro.infrastructure.model

import io.micronaut.core.annotation.Introspected

@Introspected
data class LivroRequestDTO(
    val titulo: String,
    val autor: String
)
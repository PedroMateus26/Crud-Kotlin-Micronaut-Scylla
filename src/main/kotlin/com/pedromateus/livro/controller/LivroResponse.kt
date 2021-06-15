package com.pedromateus.livro.controller

import io.micronaut.core.annotation.Introspected

@Introspected
data class LivroResponse(
    val titulo: String,
    val autor: String
)
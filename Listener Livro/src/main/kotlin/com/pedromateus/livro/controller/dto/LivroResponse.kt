package com.pedromateus.livro.controller.dto

import io.micronaut.core.annotation.Introspected

@Introspected
data class LivroResponse(
    val titulo: String,
    val autor: String
)
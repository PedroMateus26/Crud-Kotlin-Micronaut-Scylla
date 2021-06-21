package com.pedromateus.livro.subscriber.model

import io.micronaut.core.annotation.Introspected

@Introspected
data class LivroRequest(
    val titulo: String,
    val autor: String
)
package com.pedromateus.livro.database.entity

import io.micronaut.core.annotation.Introspected
import java.util.UUID

@Introspected
class LivroEntity(
    val id: UUID?,
    val titulo: String?,
    val autor: String?
)
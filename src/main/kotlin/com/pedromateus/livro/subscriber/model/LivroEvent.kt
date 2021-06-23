package com.pedromateus.livro.subscriber.model

import java.util.*

class LivroEvent(
    val id: UUID?,
    val livroRequestDTO: LivroRequestDTO?
)

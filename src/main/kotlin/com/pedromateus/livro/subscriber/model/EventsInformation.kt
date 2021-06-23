package com.pedromateus.livro.subscriber.model

data class EventsInformation(
    val livroEvent: LivroEvent,
    val event: Events
)
package com.pedromateus.livro.subscriber

import com.pedromateus.livro.service.LivroService
import com.pedromateus.livro.subscriber.model.EventsInformation
import com.pedromateus.livro.subscriber.model.LivroRequest
import io.micronaut.http.annotation.Body
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject
import org.slf4j.LoggerFactory

@NatsListener
class LivroServer(
    private val livroService: LivroService,
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Subject("livro.estoque.reposicao")
    fun salvaLivro(@Body eventsInformation: EventsInformation) {

        when (eventsInformation.event.name) {
            "SAVE" -> livroService.salvaLivro(eventsInformation.livroEvent.livroRequest!!)
            "UPDATE" -> livroService.atualizaLivro(eventsInformation.livroEvent.livroRequest!!,eventsInformation.livroEvent.id!!)
            "DELETE" -> livroService.deletaLivro(eventsInformation.livroEvent.id!!)
        }
    }


}



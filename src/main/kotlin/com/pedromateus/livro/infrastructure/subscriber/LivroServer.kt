package com.pedromateus.livro.infrastructure.subscriber

import com.pedromateus.livro.core.mappers.LivroConverter
import com.pedromateus.livro.core.ports.LivroServicePort
import com.pedromateus.livro.infrastructure.model.EventsInformation
import io.micronaut.http.annotation.Body
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject
import org.slf4j.LoggerFactory

@NatsListener
class LivroServer(
    private val livroServicePort: LivroServicePort,
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Subject("livro.estoque.reposicao")
    fun salvaLivro(@Body eventsInformation: EventsInformation) {
        logger.info("Recebendo mensagem do nats")
        val livro=LivroConverter.converteLivroEventParaLivro(eventsInformation.livroEvent)
        when (eventsInformation.event.name) {
            "SAVE" -> livroServicePort.salvaLivro(livro)
            "UPDATE" -> livroServicePort.atualizaLivro(livro)
            "DELETE" -> livroServicePort.deletaLivro(livro)
        }
    }


}



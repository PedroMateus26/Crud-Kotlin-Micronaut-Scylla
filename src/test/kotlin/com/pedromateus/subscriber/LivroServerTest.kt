package com.pedromateus.subscriber
import com.pedromateus.livro.core.model.Livro
import com.pedromateus.livro.core.service.LivroServiceimplPort
import com.pedromateus.livro.infrastructure.model.Events
import com.pedromateus.livro.infrastructure.model.EventsInformation
import com.pedromateus.livro.infrastructure.model.LivroEvent
import com.pedromateus.livro.infrastructure.subscriber.LivroServer
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class LivroServerTest:AnnotationSpec() {

    val service= mockk<LivroServiceimplPort>()
    val controller= LivroServer(service)
    lateinit var eventsInformationSave: EventsInformation
    lateinit var eventsInformationUpdate: EventsInformation
    lateinit var eventsInformationDelete: EventsInformation

    @BeforeEach
    fun setUp(){

        eventsInformationSave = EventsInformation(LivroEvent(null, "titulo","autor"), Events.SAVE)
        eventsInformationUpdate = EventsInformation(LivroEvent(UUID.randomUUID(), "titulo","autor"), Events.UPDATE)
        eventsInformationDelete = EventsInformation(LivroEvent(UUID.randomUUID(), null,null), Events.DELETE)
    }

    @Test
    fun `deve cadastrar um livro`(){

        every { service.salvaLivro(any()) } answers { Unit}
        val result=controller.salvaLivro(eventsInformationSave)

        result shouldBe Unit
    }

    @Test
    fun `deve atualizar um livro`(){

        every { service.atualizaLivro(any()) } answers { Unit}
        val result=controller.salvaLivro(eventsInformationUpdate)

        result shouldBe Unit
    }

    @Test
    fun `deve deletar um livro`(){

        every { service.deletaLivro(any()) } answers { Unit}
        val result=controller.salvaLivro(eventsInformationDelete)

        result shouldBe Unit
    }
}
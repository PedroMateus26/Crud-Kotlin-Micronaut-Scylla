package com.pedromateus.subscriber
import com.pedromateus.livro.service.LivroServiceimpl
import com.pedromateus.livro.subscriber.LivroServer
import com.pedromateus.livro.subscriber.model.*
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class LivroServerTest:AnnotationSpec() {

    val service= mockk<LivroServiceimpl>()
    val controller= LivroServer(service)

    lateinit var requestDTO: LivroRequestDTO
    lateinit var eventsInformationSave: EventsInformation
    lateinit var eventsInformationUpdate: EventsInformation
    lateinit var eventsInformationDelete: EventsInformation

    @BeforeEach
    fun setUp(){
        requestDTO= LivroRequestDTO(titulo = "titulo",autor = "autor")
        eventsInformationSave = EventsInformation(LivroEvent(null, requestDTO), Events.SAVE)
        eventsInformationUpdate = EventsInformation(LivroEvent(UUID.randomUUID(), requestDTO), Events.UPDATE)
        eventsInformationDelete = EventsInformation(LivroEvent(UUID.randomUUID(), null), Events.DELETE)
    }

    @Test
    fun `deve cadastrar um livro`(){

        every { service.salvaLivro(any()) } answers { Unit}
        val result=controller.salvaLivro(eventsInformationSave)

        result shouldBe Unit
    }

    @Test
    fun `deve atualizar um livro`(){

        every { service.atualizaLivro(any(),any()) } answers { Unit}
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
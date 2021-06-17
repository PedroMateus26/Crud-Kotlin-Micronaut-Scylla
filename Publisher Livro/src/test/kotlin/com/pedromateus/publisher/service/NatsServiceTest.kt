package com.pedromateus.publisher.service

import com.pedromateus.publisher.controller.dto.LivroRequest
import com.pedromateus.publisher.controller.dto.LivroResponse
import com.pedromateus.publisher.infraestrutura.nats.LivroClient
import com.pedromateus.publisher.infraestrutura.service.NatsService
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk

@MicronautTest
class NatsServiceTest: AnnotationSpec() {
    val publisher = mockk<LivroClient>()
    val natsService= NatsService(publisher)

    lateinit var livroResponse: LivroResponse

    @BeforeEach
    fun setUp(){
        livroResponse= LivroResponse("titulo","autor")
    }

    @Test
    fun `deve enviar o objeto para service`(){
        every { publisher.sendLivro(any()) } answers {}
        val result=natsService.sendLivro(livroResponse)
        result shouldBe Unit

    }
}
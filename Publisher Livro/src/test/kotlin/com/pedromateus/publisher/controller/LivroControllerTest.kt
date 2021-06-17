package com.pedromateus.publisher.controller

import com.pedromateus.publisher.controller.dto.LivroRequest
import com.pedromateus.publisher.controller.dto.LivroResponse
import com.pedromateus.publisher.infraestrutura.service.NatsService
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk


@MicronautTest
class LivroControllerTest: AnnotationSpec() {

    val natsService= mockk<NatsService>()
    val controller=LivroController(natsService)

    lateinit var livroRequest: LivroRequest

    @BeforeEach
    fun setUp(){
        livroRequest= LivroRequest("titulo","autor")
    }

    @Test
    fun `deve enviar o objeto para service`(){
        every { natsService.sendLivro(any()) } answers {}
        val result=controller.LivroParaNats(livroRequest)
        result shouldBe Unit
    }

}
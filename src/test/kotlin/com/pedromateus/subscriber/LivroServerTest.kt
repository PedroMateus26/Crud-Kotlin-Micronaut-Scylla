package com.pedromateus.subscriber
import com.pedromateus.livro.service.LivroServiceimpl
import com.pedromateus.livro.subscriber.LivroServer
import com.pedromateus.livro.subscriber.model.LivroRequest
import com.pedromateus.livro.subscriber.model.TipoDeOperaçãoEnum
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk

@MicronautTest
class LivroServerTest:AnnotationSpec() {

    val service= mockk<LivroServiceimpl>()
    val controller= LivroServer(service)

    lateinit var request: LivroRequest

    @BeforeEach
    fun setUp(){
        request= LivroRequest(titulo = "titulo",autor = "autor",TipoDeOperaçãoEnum.SAVE)

    }

    @Test
    fun `deve cadastrar um livro`(){

        every { service.salvaLivro(any()) } answers { Unit}
        val result=controller.salvaLivro(livroRequest = request)

        result shouldBe Unit
    }
}
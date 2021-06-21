package com.pedromateus.livro.service

import com.pedromateus.livro.repository.LivroRepository
import com.pedromateus.livro.subscriber.model.LivroRequest
import javax.inject.Singleton

@Singleton
class LivroServiceimpl(private val livroRepository: LivroRepository):LivroService {

    override fun salvaLivro(livroRequest: LivroRequest) = livroRepository.salvaLivro(livroRequest)



}

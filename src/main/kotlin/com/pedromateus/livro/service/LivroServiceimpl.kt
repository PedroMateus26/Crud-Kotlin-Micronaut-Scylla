package com.pedromateus.livro.service

import com.pedromateus.livro.repository.LivroRepository
import com.pedromateus.livro.subscriber.model.LivroRequest
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroServiceimpl(private val livroRepository: LivroRepository):LivroService {

    override fun salvaLivro(livroRequest: LivroRequest) = livroRepository.salvaLivro(livroRequest)
    override fun atualizaLivro(livroRequest: LivroRequest,id:UUID)=livroRepository.atualizaLivro(livroRequest,id)
    override fun deletaLivro(id:UUID)=livroRepository.deletaLivro(id)


}

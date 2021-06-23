package com.pedromateus.livro.service

import com.pedromateus.livro.repository.LivroRepository
import com.pedromateus.livro.subscriber.model.LivroRequestDTO
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroServiceimpl(private val livroRepository: LivroRepository):LivroService {

    override fun salvaLivro(livroRequestDTO: LivroRequestDTO) = livroRepository.salvaLivro(livroRequestDTO)
    override fun atualizaLivro(livroRequestDTO: LivroRequestDTO, id:UUID)=livroRepository.atualizaLivro(livroRequestDTO,id)
    override fun deletaLivro(id:UUID)=livroRepository.deletaLivro(id)


}

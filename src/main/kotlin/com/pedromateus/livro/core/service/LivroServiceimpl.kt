package com.pedromateus.livro.core.service

import com.pedromateus.livro.core.mappers.LivroConverter
import com.pedromateus.livro.core.ports.LivroRepository
import com.pedromateus.livro.core.ports.LivroService
import com.pedromateus.livro.infrastructure.model.LivroRequestDTO
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroServiceimpl(private val livroRepository: LivroRepository): LivroService {

    override fun salvaLivro(livroRequestDTO: LivroRequestDTO) = livroRepository.salvaLivro(LivroConverter.dtoParaEntity(livroRequestDTO))
    override fun atualizaLivro(livroRequestDTO: LivroRequestDTO, id:UUID)=livroRepository.atualizaLivro(LivroConverter.dtoParaEntity(livroRequestDTO),id)
    override fun deletaLivro(id:UUID)=livroRepository.deletaLivro(id)


}

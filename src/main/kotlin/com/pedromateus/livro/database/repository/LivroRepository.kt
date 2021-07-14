package com.pedromateus.livro.database.repository

import com.pedromateus.livro.database.entity.LivroEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.UUID

@Repository
interface LivroRepository:JpaRepository<LivroEntity,UUID> {
}
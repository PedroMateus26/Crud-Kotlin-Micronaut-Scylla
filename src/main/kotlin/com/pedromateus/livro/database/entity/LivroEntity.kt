package com.pedromateus.livro.database.entity

import io.micronaut.core.annotation.Introspected
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "prateleira")
class LivroEntity(
    @field: Id
    @field: GeneratedValue
    var id:UUID?=null,
    val titulo: String?="",
    val autor: String?=""
){
    @CreationTimestamp
    val localDateTime:LocalDateTime?=LocalDateTime.now()
}
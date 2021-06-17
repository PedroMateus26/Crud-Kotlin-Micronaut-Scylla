package com.pedromateus.publisher.controller.dto

data class LivroRequest(
    val titulo:String,
    val autor:String
){
    fun paraLivroResponse()=LivroResponse(titulo,autor)
}
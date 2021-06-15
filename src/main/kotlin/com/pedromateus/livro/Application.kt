package com.pedromateus.livro

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.pedromateus.livro")
		.start()
}


package com.pedromateus.publisher

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.pedromateus.publisher")
		.start()
}


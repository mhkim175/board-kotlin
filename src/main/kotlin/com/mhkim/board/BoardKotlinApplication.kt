package com.mhkim.board

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BoardKotlinApplication

fun main(args: Array<String>) {
	runApplication<BoardKotlinApplication>(*args)
}

package com.example.flow

import kotlinx.coroutines.flow.flow

suspend fun main() {
    println("Start")
    val flow = flow {
        println("Emitting first value")
        emit(1)
        println("Emitting second value")
        emit(2)
        println("Emitting third value")
    }
    flow.collect { println("The next number is $it") }
    println("End")
}
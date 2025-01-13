package com.example.sequences

val seq = sequence {
    println("Generating first value")
    yield(1)
    println("Generating second value")
    yield(2)
    println("Generating third value")
}

fun main() {
    println("Start")
    println(seq.toList())
    println("End")

    for (i in seq) {
        println("The next number is $i")
    }
}
package com.example.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/***
Here is an example of using the launch coroutine builder in Kotlin coroutines to start a new coroutine:
In this example:
A coroutine is launched using the launch coroutine builder.
The coroutine prints "World!" after a delay of 1 second.
The main function prints "Hello," and the program ends.
 */
fun main() = runBlocking {
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
}


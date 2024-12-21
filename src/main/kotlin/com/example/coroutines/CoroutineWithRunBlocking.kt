package com.example.coroutines

import kotlinx.coroutines.*

/***
Here is an example of a Kotlin class that uses runBlocking to run a coroutine:

In this example:
The com.example.CoroutineExample class has a method execute that uses runBlocking to start a coroutine.
Inside runBlocking, a coroutine is launched that delays for 1 second and then prints a message.
The main function creates an instance of com.example.CoroutineExample and calls the execute method.
The output shows that the message from the coroutine is printed after the "RunBlocking started" message.

 */
class CoroutineExample {
    fun execute() = runBlocking {
        launch {
            delay(1000L)
            println("Task from runBlocking")
        }
        println("RunBlocking started")
    }
}

fun main() {
    val example = CoroutineExample()
    example.execute()
}
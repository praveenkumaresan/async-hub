package com.example

import kotlinx.coroutines.*

/***
Here is an example of a Kotlin class that demonstrates the use of withContext to switch coroutine contexts:

In this example:
The CoroutineWithContext class has an execute method that uses runBlocking to start a coroutine.
Inside the coroutine, withContext is used to switch to the Dispatchers.IO context.
The coroutine prints messages before and after switching contexts, and delays for 1 second in the IO context.
The main function creates an instance of CoroutineWithContext and calls the execute method.
The output shows the context of the coroutine before and after switching to the IO context.

 */
class CoroutineWithContext {
    fun execute() = runBlocking {
        println("Starting in context: ${coroutineContext[Job]}")

        withContext(Dispatchers.IO) {
            println("Switched to IO context: ${coroutineContext[Job]}")
            delay(1000L)
            println("Task in IO context")
        }

        println("Back to original context: ${coroutineContext[Job]}")
    }
}

fun main() {
    val example = CoroutineWithContext()
    example.execute()
}
package com.example

import kotlinx.coroutines.*


/***
In Kotlin coroutines, you can implement cancellation by using the cancel function on a Job or Deferred object. Here is an example demonstrating how to cancel a coroutine:

In this example:
A coroutine is launched with the launch builder.
The coroutine prints a message and delays for 500 milliseconds in a loop.
The main coroutine delays for 1300 milliseconds and then cancels the job using cancelAndJoin.
The cancelAndJoin function cancels the job and waits for its completion.

 **/
fun main() = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("Job: I'm sleeping $i ...")
            delay(500L)
        }
    }

    delay(1300L) // Delay for a while
    println("Main: I'm tired of waiting!")
    job.cancelAndJoin() // Cancel the job and wait for its completion
    println("Main: Now I can quit.")
}
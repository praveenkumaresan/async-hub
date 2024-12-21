package com.example.coroutines

import kotlinx.coroutines.*

/***
Here is an example demonstrating the use of Kotlin coroutines to spin multiple threads and print the thread names, including the main thread and other threads:
In this example:
The main function runs in the main thread.
Two coroutines are launched: one in the main thread and one in a background thread using Dispatchers.Default.
Each coroutine prints the thread name at the start and end of its execution.
The join function is used to wait for both coroutines to complete before the main program ends.

 */
fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")

    val job1 = launch {
        println("Fake work starts: ${Thread.currentThread().name}")
        delay(1000)
        println("Fake work finished: ${Thread.currentThread().name}")
    }

    val job2 = launch(Dispatchers.Default) {
        println("Fake work starts: ${Thread.currentThread().name}")
        delay(1000)
        println("Fake work finished: ${Thread.currentThread().name}")
    }

    job1.join()
    job2.join()

    println("Main program ends: ${Thread.currentThread().name}")
}
package com.example.fundamentals.stucturedconcurrency

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/*
1. Scoped Co-routines
Coroutines must be launched within a CoroutineScope. The scope provides lifecycle management and ensures proper cancellation of coroutines.

Example:

Here:
- The launch coroutine runs within the runBlocking scope.
- The main thread waits for the launch coroutine to complete before exiting.
*/
fun main() = runBlocking { // runBlocking creates a CoroutineScope
    launch { // Child coroutine
        delay(1000L)
        println("Task completed!")
    }
    println("Main coroutine ends, waiting for child coroutine...")
}


package com.example.fundamentals

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/*
 Synchronous Coroutines
     - Synchronous coroutines are those that:
            - Block the current thread while waiting for the coroutine's tasks to complete.
            - Typically created using the runBlocking coroutine builder.
            - Used to bridge the gap between regular blocking code and coroutines.
     - Key Points:
            - Suitable for main functions in standalone apps or test cases.

 Key Characteristics:
     - The main thread is blocked until runBlocking completes.
     - All code inside the runBlocking block runs in a coroutine, but the thread it runs on is blocked.

 */
fun main() {
    println("Main starts: [${Thread.currentThread().name}]")

    runBlocking { // Synchronous coroutine
        println("Task inside runBlocking starts. ${Thread.currentThread().name}")
        delay(1000L) // Suspend for 1 second
        println("Task inside runBlocking ends. ${Thread.currentThread().name}")
    }

    println("Main ends: [${Thread.currentThread().name}]")
}

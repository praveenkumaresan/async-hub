package com.example.fundamentals

import kotlinx.coroutines.*

/*
    The `launch` coroutine builder is used to launch a new coroutine without blocking the current thread.
    The `withContext` function is used to switch the context of the coroutine.
    The `Dispatchers.Default` context is used to run the coroutine in a background thread.
    The `delay` function is used to suspend the coroutine for a specified time.
 */

fun main() = runBlocking {
    println("Main starts: [${Thread.currentThread().name}]")

    launch {
        withContext(Dispatchers.Default) {
            println("Task 1 starts: [${Thread.currentThread().name}]")
            delay(1000L) // Suspend but does not block the thread
            println("Task 1 ends: [${Thread.currentThread().name}]")
        }
    }
    println("Main ends: [${Thread.currentThread().name}]")
}
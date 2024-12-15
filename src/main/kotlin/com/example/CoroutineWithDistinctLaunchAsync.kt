package com.example

import kotlinx.coroutines.*


/***
In Kotlin coroutines, launch and async are two different coroutine builders that serve distinct purposes:
launch:
Purpose: Used to launch a new coroutine without blocking the current thread. It is primarily used for fire-and-forget operations.
Return Type: Returns a Job object, which represents the coroutine and can be used to manage its lifecycle (e.g., cancel it).
Usage: Suitable for operations where you do not need a result to be returned.

val job = launch {
    // Coroutine code
}`

async:
Purpose: Used to launch a new coroutine and return a result. It is used for concurrent operations where you need to get a result back.
Return Type: Returns a Deferred object, which is a subclass of Job and represents a future result. You can use the await function to get the result.
Usage: Suitable for operations where you need to return a result.
val deferred = async {
    // Coroutine code
    return@async result
}
val result = deferred.await()

In this example:
launch is used to start a coroutine that prints a message. The join function is used to wait for its completion.
async is used to start a coroutine that returns a result. The await function is used to get the result.

 */
fun main() = runBlocking {
    // Using launch
    val job = launch {
        println("Running in launch: ${Thread.currentThread().name}")
    }
    job.join() // Wait for the job to complete

    // Using async
    val deferred = async {
        println("Running in async: ${Thread.currentThread().name}")
        42 // Return a result
    }
    val result = deferred.await() // Wait for the result
    println("Result from async: $result")
}
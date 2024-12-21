package com.example.fundamentals

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


/*
Key Characteristics:
 - Suspension: When delay(1000L) is called, the coroutine running fetchData is paused, and the thread is released for other tasks.
 - Sequential: Code after the delay() will resume in the same coroutine when the suspension ends.

Key Points:
 - Does not create a coroutine by itself.
 - It’s a way to represent long-running operations (e.g., network calls) in a sequential and readable manner.
 */

// A suspending function is a function that can be paused and resumed at a later time.
// The `suspend` keyword is used to mark a function as a suspending function.
// The `delay` function is a suspending function that suspends the coroutine for a specified time without blocking the thread.
suspend fun fetchData(): String {
    println("Fetching data... [${Thread.currentThread().name}]")
    delay(1000L) // Suspends for 1 second
    return "Data fetched!"
}

// The `runBlocking` coroutine builder is used to block the main thread until all coroutines inside it complete.
// The `fetchData` function is a suspending function that can be called from a coroutine.
// The `runBlocking` coroutine builder is used to call the `fetchData` function from the `main` function.
fun main() = runBlocking {
    val result = fetchData() // Call suspend function
    println(result) // Output: "Data fetched!"
}

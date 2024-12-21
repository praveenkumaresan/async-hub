package com.example.fundamentals

import kotlinx.coroutines.*


/*
      The code demonstrates the difference between synchronous and asynchronous execution using Kotlin coroutines.
      It uses the runBlocking coroutine builder to block the main thread until all coroutines inside it complete. Two coroutines are launched within
      runBlocking to show the behavior with and without context switching.

      The first coroutine is launched without context switching, running on the main thread.
      The second coroutine uses withContext(Dispatchers.Default) to switch to a background thread.
      The delay function is used to suspend the coroutine for a specified time without blocking the thread.
 */

/**
 * Difference Between launch and withContext in runBlocking Scope
 *
 * Feature                | launch                                         | Direct withContext
 * -----------------------------------------------------------------------------------------------
 * Concurrency            | Creates a new coroutine that runs concurrently | Executes the code sequentially within
 *                        | with the rest of the code in the runBlocking   | the runBlocking scope.
 *                        | scope.                                         |
 * -----------------------------------------------------------------------------------------------
 * Return Type            | Returns a Job (represents the coroutine's      | Returns the result of the code executed
 *                        | lifecycle). Does not return the result of      | inside it (like a regular function).
 *                        | the block.                                     |
 * -----------------------------------------------------------------------------------------------
 * Use Case               | Use for fire-and-forget tasks or tasks that    | Use for tasks where you need the result
 *                        | run concurrently.                              | or when switching context for sequential
 *                        |                                               | execution.
 * -----------------------------------------------------------------------------------------------
 * Lifecycle Management   | Runs independently of the runBlocking block    | Blocks execution until the withContext
 *                        | unless explicitly join()ed.                    | block finishes.
 * -----------------------------------------------------------------------------------------------
 * Thread Context         | Inherits the thread/context from the parent    | Switches context to the specified
 *                        | runBlocking or can switch contexts.            | Dispatcher (e.g., Dispatchers.Default)
 *                        |                                               | immediately for the block.
 * -----------------------------------------------------------------------------------------------
 * Suspension             | Suspension only affects the coroutine launched | Suspension affects the current coroutine
 *                        | by launch. The parent scope continues          | in the runBlocking scope. Other code in
 *                        | executing other code.                          | the runBlocking scope does not continue
 *                        |                                               | until the withContext block finishes.
 */

/**
 * When to Use Each Version
 *
 * Scenario                        | Use Without withContext                      | Use With withContext(Dispatchers.Default)
 * -----------------------------------------------------------------------------------------------
 * UI Thread (e.g., Android)       | Small tasks or lightweight operations.       | Offload heavy computations to background threads.
 * Standalone Applications         | Simple coroutines that don’t require thread  | For better performance on multicore systems.
 *                                 | switching.                                   |
 * Testing/Debugging               | When running everything sequentially on a    | Simulate real-world thread handling and performance.
 *                                 | single thread is fine.                       |
 *
 */
fun main() = runBlocking {
    println("Main starts: [${Thread.currentThread().name}]")

    // Without withContext
    launch {
        println("Task 1 (no context switch) starts: [${Thread.currentThread().name}]")
        delay(500L)
        println("Task 1 (no context switch) ends: [${Thread.currentThread().name}]")
    }

    // With withContext
    launch {
        withContext(Dispatchers.Default) {
            println("Task 2 (context switch) starts: [${Thread.currentThread().name}]")
            delay(500L)
            println("Task 2 (context switch) ends: [${Thread.currentThread().name}]")
        }
    }

    println("Main ends: [${Thread.currentThread().name}]")
}

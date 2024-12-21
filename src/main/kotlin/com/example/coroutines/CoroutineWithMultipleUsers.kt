package com.example.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * In this example, we launch 100,000 coroutines using the launch builder. Each coroutine delays for 1000 milliseconds
 * and prints a message. The main coroutine waits for all the coroutines to finish before exiting.
 * Compared to ThreadWithMultipleUsers.kt, this example uses coroutines instead of threads to achieve concurrency.
 * However, the output is similar, showing that coroutines can be used to achieve concurrency in Kotlin.
 *
 * The coroutine is paused at that point (e.g., delay(1000L)) and remembers its state so it can resume later.
 *
 * Unlike traditional blocking operations (like Thread.sleep()), suspension does not block the thread.
 * Instead, the thread can be freed to do other work (e.g., execute other coroutines).
 *
 * Suspension vs Blocking
 * - Blocking a Thread (Traditional Threads):
 *      If you call Thread.sleep(1000L), the thread is completely blocked for 1 second.
 *      A blocked thread cannot do anything else until the sleep finishes.
 *      If you have a limited number of threads, blocking them can lead to inefficiency or thread starvation.
 *
 * - Suspending in Coroutines:
 *      When a coroutine hits delay(1000L), it suspends execution.
 *      The thread running the coroutine is released back to the thread pool and can now run other coroutines.
 *      After 1 second, the coroutine resumes execution from where it left off.
 *
 * How Suspension Works Internally:
 *
 * - Coroutine State Saving:
 *
 *          When delay(1000L) is called, the coroutine saves its current state (e.g., the current line, local variables,
 *          and context). This allows it to "pause" and resume execution later.
 *
 * - Thread Release:
 *
 *          Since the coroutine is suspended, the thread executing it is no longer needed for this coroutine.
 *          The thread can go back to the thread pool and execute other coroutines.
 *
 * - Resumption:
 *
 *          Once the delay completes, the coroutine is scheduled to resume on an available thread.
 *          It picks up execution from the saved state as if nothing happened.
 */
fun main() = runBlocking{
    repeat(100_000){
        launch {
            delay(1000L)
            println("Coroutine $it finished in ${Thread.currentThread().name}")
        }
    }
}
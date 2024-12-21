package com.example.thread

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

/**
 * This is a simple example of how to create multiple threads in Kotlin.
 * In this example, 100,000 threads are created, each sleeping for 1 second before printing a message.
 * Out of the 100,000 threads, only a few threads will run concurrently due to the limitations of the system.
 * The threads are created using the thread function from the kotlin.concurrent package.
 */
fun main() {
    repeat(100000) {
        thread {
            Thread.sleep(1000)
            println("Thread $it finished in ${Thread.currentThread().name}")
        }
    }
    runBlocking {
        repeat(100000) {
            launch {
                delay(1000L)
                println("Thread $it finished in ${Thread.currentThread().name}")
            }
        }
    }
}
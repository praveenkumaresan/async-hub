package com.example.fundamentals.stucturedconcurrency

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter


/*
3. Cancellation
Structured concurrency ensures that if a parent coroutine is canceled, all its child coroutines are also canceled.

Example:
 */
fun main() = runBlocking {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault())
    val currentTime = Instant.now()
    println("Current time: ${formatter.format(currentTime)}")

    val job = launch {
        repeat(5) { i ->
            println("Child coroutine: $i")
            delay(3000L)
        }
    }
    delay(8000L)
    val cancelTime = Instant.now()
    println("Canceling parent coroutine...now time is ${formatter.format(cancelTime)}")
    job.cancelAndJoin() // Cancels the coroutine and waits for its completion
    println("Parent coroutine canceled")
}



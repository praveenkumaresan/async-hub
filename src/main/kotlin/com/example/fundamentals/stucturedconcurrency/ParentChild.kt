package com.example.fundamentals.stucturedconcurrency

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking



/*
2. Parent-Child Relationship
Child coroutines inherit the context of their parent coroutine. The parent coroutine automatically waits for all its child coroutines to complete.

Example:

The runBlocking scope ensures the parent coroutine waits for both child coroutines to finish.
*/

fun main() = runBlocking {
    launch {
        println("Child coroutine 1 starts")
        delay(500L)
        println("Child coroutine 1 ends")
    }
    launch {
        println("Child coroutine 2 starts")
        delay(1000L)
        println("Child coroutine 2 ends")
    }
    println("Parent coroutine ends, waiting for children...")
}


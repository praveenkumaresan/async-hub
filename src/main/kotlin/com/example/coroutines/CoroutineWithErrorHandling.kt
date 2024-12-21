package com.example.coroutines

import kotlinx.coroutines.*

/***
Here is an example of error handling in Kotlin coroutines using try-catch blocks:

In this example:
The launch coroutine builder is used to start a coroutine that throws an IndexOutOfBoundsException. The exception is caught within the coroutine using a try-catch block.
The async coroutine builder is used to start a coroutine that throws an ArithmeticException. The exception is caught when calling await on the deferred result.
 */

fun main() = runBlocking {
    val job = launch {
        try {
            println("Throwing exception from launch")
            throw IndexOutOfBoundsException()
        } catch (e: IndexOutOfBoundsException) {
            println("Caught IndexOutOfBoundsException")
        } finally {
            println("Finally in launch")
        }
    }
    job.join()

    val deferred = async {
        println("Throwing exception from async")
        throw ArithmeticException()
    }
    try {
        deferred.await()
    } catch (e: ArithmeticException) {
        println("Caught ArithmeticException")
    }
}
package com.example.coroutines

import kotlinx.coroutines.*

/***
Here is an example demonstrating the use of Kotlin coroutines with async and await for concurrent programming:

In this example, two coroutines are launched using async, which allows them to run concurrently. The await function is used to get the result of each coroutine once they complete. The program will print "Hello World" after both coroutines have finished their delays.

 */
fun main() = runBlocking {
    val deferred1 = async {
        delay(1000L)
        "Hello"
    }
    val deferred2 = async {
        delay(2000L)
        "World"
    }
    println("${deferred1.await()} ${deferred2.await()}")
}
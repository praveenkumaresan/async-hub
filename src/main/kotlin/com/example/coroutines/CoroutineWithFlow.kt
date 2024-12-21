package com.example.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/***
Flow in Kotlin coroutines is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value. It is a cold stream, meaning that the code inside a flow builder does not run until the flow is collected.  Here is an example demonstrating the use of Flow in Kotlin coroutines:

In this example:
simpleFlow is a function that returns a Flow of integers.
The flow builder is used to create the flow.
Inside the flow builder, values are emitted using the emit function.
The main function collects the flow and prints each emitted value.
This demonstrates the basic usage of Flow in Kotlin coroutines.

 */
fun simpleFlow(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(100) // Simulate some work
        emit(i) // Emit next value
    }
}

fun main() = runBlocking {
    // Collect the flow
    simpleFlow().collect { value ->
        println(value)
    }
}
package com.example.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel


/***
here is an example of using channels in Kotlin coroutines to send and receive messages between coroutines:

In this example:
A Channel of type Int is created.
The producer coroutine sends integers 1 to 5 to the channel.
The consumer coroutine receives and prints the integers from the channel.
The channel is closed after the producer finishes sending all elements.

 */
fun main() = runBlocking {
    val channel = Channel<Int>()

    // Producer coroutine
    val producer = launch {
        for (x in 1..5) {
            println("Sending $x")
            channel.send(x)
        }
        channel.close() // Close the channel to indicate no more elements
    }

    // Consumer coroutine
    val consumer = launch {
        for (y in channel) {
            println("Received $y")
        }
    }

    producer.join()
    consumer.join()
}
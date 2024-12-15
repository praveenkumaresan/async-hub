import kotlinx.coroutines.*


/*
Structured concurrency in Kotlin coroutines ensures that coroutines are launched in a structured way, making it easier to manage their lifecycle and handle errors. It involves using coroutine scopes to define the lifecycle of coroutines and ensuring that they are properly managed.  Here is an example demonstrating structured concurrency in Kotlin coroutines:
In this example:
runBlocking creates a coroutine scope that blocks the main thread.
coroutineScope defines a new scope within runBlocking.
Two coroutines are launched within the coroutineScope.
The coroutineScope ensures that all coroutines within it complete before it finishes.
The message "Coroutine scope is over" is printed only after all coroutines in the coroutineScope have completed.
 */
fun main() = runBlocking {
    // Define a coroutine scope
    coroutineScope {
        // Launch a coroutine within the scope
        launch {
            delay(1000)
            println("Task from nested launch")
        }

        // Another coroutine within the same scope
        launch {
            delay(500)
            println("Task from another nested launch")
        }

        println("Task from coroutine scope") // This line is executed immediately
    }

    println("Coroutine scope is over") // This line is executed after the scope is complete
}
import kotlinx.coroutines.*

/*
Here is an example of a Kotlin class that demonstrates the use of timeouts with coroutines:

n this example:
The CoroutineWithTimeout class has an execute method that uses runBlocking to start a coroutine.
Inside the coroutine, withTimeout is used to limit the execution time to 1500 milliseconds.
The coroutine repeats a task that prints a message and delays for 500 milliseconds.
If the task takes longer than the specified timeout, a TimeoutCancellationException is thrown and caught, printing a timeout message.
The main function creates an instance of CoroutineWithTimeout and calls the execute method.
The output shows that the tasks are printed until the timeout is reached, and the timeout message is printed.

 */
class CoroutineWithTimeout {
    fun execute() = runBlocking {
        try {
            withTimeout(1500L) {
                repeat(1000) { i ->
                    println("Task $i")
                    delay(500L)
                }
            }
        } catch (e: TimeoutCancellationException) {
            println("Task timed out")
        }
    }
}

fun main() {
    val example = CoroutineWithTimeout()
    example.execute()
}
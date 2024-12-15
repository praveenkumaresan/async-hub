import kotlinx.coroutines.*

/*
Here is an example of a Kotlin class that demonstrates the use of a suspend function:

In this example:
The SuspendFunctionExample class has a suspend function longRunningTask that delays for 1 second and then prints a message.
The execute method uses runBlocking to start a coroutine that calls the longRunningTask function.
The main function creates an instance of SuspendFunctionExample and calls the execute method.
The output shows that the message from the suspend function is printed after the "RunBlocking started" message.

 */
class SuspendFunctionExample {
    suspend fun longRunningTask() {
        delay(1000L)
        println("Task from suspend function")
    }

    fun execute() = runBlocking {
        launch {
            longRunningTask()
        }
        println("RunBlocking started")
    }
}

fun main() {
    val example = SuspendFunctionExample()
    example.execute()
}
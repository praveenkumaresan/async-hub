import kotlinx.coroutines.*

/*
Here is an example of a Kotlin class that demonstrates the use of CoroutineScope:

In this example:
The CoroutineScopeExample class implements CoroutineScope and defines a Job and Dispatcher for the coroutine context.
The execute method launches a coroutine that delays for 1 second and then prints a message.
The cleanup method cancels the job to clean up resources.
The main function creates an instance of CoroutineScopeExample, calls the execute method, and waits for the coroutine to complete before calling cleanup.
The output shows that the message from the coroutine is printed after the "CoroutineScope started" message.

 */
class CoroutineScopeExample : CoroutineScope {
    private val job = Job()
    override val coroutineContext = Dispatchers.Default + job

    fun execute() {
        launch {
            delay(1000L)
            println("Task from CoroutineScope")
        }
        println("CoroutineScope started")
    }

    fun cleanup() {
        job.cancel()
    }
}

fun main() {
    val example = CoroutineScopeExample()
    example.execute()
    Thread.sleep(2000L) // Wait for the coroutine to complete
    example.cleanup()
}
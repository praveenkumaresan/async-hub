package com.example.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
Here is an example demonstrating the use of Kotlin coroutines to spin multiple threads and print the thread names,
including the main thread and other threads:

In this example:
    - The main function runs in the main thread.
    - Five coroutines are launched in the background using Dispatchers.Default.
    - Each coroutine prints the thread name at the start and end of its execution.
    - The main coroutine waits for all child coroutines to finish before the program ends.

Key Observations

- Started on One Thread:

        Each coroutine initially starts execution on a thread from the Default Dispatcher thread pool.

- Suspended During delay():

        When delay(1000L) is called, the coroutine suspends, and the thread it was using becomes free to execute other tasks.

- Resumed on a Different Thread:

        After 1000 milliseconds, the coroutine resumes execution. However, it may continue on a different thread from the
        thread pool, depending on which thread is available.

For example:

Coroutine 0 started on DefaultDispatcher-worker-1 but resumed on DefaultDispatcher-worker-4.

Why Does This Happen?
The Default Dispatcher uses a shared pool of threads. When a coroutine resumes after suspension, the Kotlin coroutine
scheduler assigns it to any available thread in the pool. Threads are not "reserved" for specific coroutines, making the
system highly efficient.

What to Learn from This:
Coroutines are not bound to a specific thread.
Suspension allows threads to be reused for other tasks while coroutines wait.
Upon resumption, coroutines can be executed on a different thread, optimizing resource utilization.


Internal Details of the Coroutine Scheduler:

Dispatcher Thread Pools:
    - The scheduler maintains a thread pool where threads are shared between coroutines.

Work Stealing:
    - If one thread finishes its tasks quickly, it can "steal" tasks (coroutines ready to resume) from another thread,
ensuring efficient resource usage.

State Restoration:
    - When a coroutine suspends, the state machine saves:
        - The current stack frame (execution point).
        - Local variables.
        - Context details (like the dispatcher).
On resumption, the state is restored, and execution continues seamlessly.

 */
fun main() = runBlocking {
    println("Main coroutine started on thread: ${Thread.currentThread().name}")

    repeat(5) { i ->
        launch(Dispatchers.Default) {
            println("Coroutine $i started on thread: ${Thread.currentThread().name}")
            delay(1000L) // Suspends the coroutine
            println("Coroutine $i resumed on thread: ${Thread.currentThread().name}")
        }
    }
    println("Main coroutine is waiting for child coroutines to finish...")
}
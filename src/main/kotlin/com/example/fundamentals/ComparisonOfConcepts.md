# Comparison of Concepts

| Feature                | Suspending Functions                            | Synchronous Coroutines (e.g., `runBlocking`) | Asynchronous Coroutine Builders (`launch`, `async`)                |
|------------------------|-------------------------------------------------|----------------------------------------------|--------------------------------------------------------------------|
| **Purpose**            | Define long-running or asynchronous tasks.      | Bridge blocking code and coroutines.         | Start coroutines that run concurrently.                            |
| **Creates Coroutine?** | No, must be called within a coroutine.          | Yes, but blocks the current thread.          | Yes, runs concurrently without blocking.                           |
| **Thread Blocking?**   | No.                                             | Yes.                                         | No.                                                                |
| **Use Case**           | Encapsulate suspendable logic.                  | Main functions or test cases.                | Fire-and-forget tasks (`launch`), or tasks with results (`async`). |
| **Return Type**        | Return a value directly like regular functions. | None.                                        | `Job` (for `launch`), `Deferred` (for `async`).                    |

## Suspending Functions

Suspending functions are a core concept in Kotlin coroutines. They are regular functions that can pause and resume

Examples:

The selected code demonstrates the use of a suspending function in Kotlin coroutines. Here's a brief explanation:  
- suspend fun fetchData(): String: Defines a suspending function that simulates a long-running task by delaying for 1 second and then returning a string "Data fetched!".
- runBlocking: Blocks the main thread until all coroutines inside it complete.
- println("Fetching data..."): Prints a message indicating the start of data fetching.
- val data = fetchData(): Calls the suspending function fetchData and waits for its result.
- println(data): Prints the result of the fetchData function.
- The code prints "Fetching data...", waits for 1 second, and then prints "Data fetched!".

```kotlin
suspend fun fetchData(): String {
    delay(1000L) // Simulate a network or long-running task
    return "Data fetched!"
}

fun main() = runBlocking {
    println("Fetching data...")
    val data = fetchData() // Calling the suspending function
    println(data)
}
```

The selected code demonstrates the use of suspending functions in Kotlin coroutines. Here's a brief explanation:
- suspend fun fetchUserData(): String: Defines a suspending function that simulates a network call by delaying for 1 second and then returning a string "User data fetched".
- suspend fun fetchOrders(): String: Defines another suspending function that simulates another network call by delaying for 800 milliseconds and then returning a string "Orders fetched".
- main: The main function uses runBlocking to start a coroutine that calls the fetchUserData and fetchOrders functions concurrently using async.
- async: Starts
- println("Processing..."): Prints a message indicating that the data is being processed.
- println(userData.await()): Waits for the result of the fetchUserData function and prints it.
- println(orders.await()): Waits for the result of the fetchOrders function and prints it.
- The code prints "Processing...", waits for 1 second, prints "User data fetched", waits for another 800 milliseconds, and then prints "Orders fetched".
- The two suspending functions are called concurrently, and the results are printed sequentially.

```kotlin
suspend fun fetchUserData(): String {
    delay(1000L) // Simulate network call
    return "User data fetched"
}

suspend fun fetchOrders(): String {
    delay(800L) // Simulate another network call
    return "Orders fetched"
}

fun main() = runBlocking {
    val userData = async { fetchUserData() }
    val orders = async { fetchOrders() }

    println("Processing...")
    println(userData.await()) // Wait for user data
    println(orders.await())   // Wait for orders
}

```
## Synchronous Coroutines

Synchronous coroutines are used to bridge blocking code and coroutines. They are used in main functions or test cases.

Examples:

The selected code demonstrates the use of synchronous coroutines in Kotlin. Here's a brief explanation:
- runBlocking: Blocks the main thread until all coroutines inside it complete.
- println("Main starts"): Prints a message indicating the start of the main function.
- runBlocking: Starts a new coroutine that calls the fetchData function.
- fetchData: Simulates a network or long-running task by delaying for 1 second and then returning a string "Data fetched!".
- println(data): Prints the result of the fetchData function.
- println("Main ends"): Prints a message indicating the end of the main function.
- The code prints "Main starts", waits for 1 second, prints "Data fetched!", and then prints "Main ends".
- The fetchData function is called synchronously within the runBlocking coroutine.
```kotlin
suspend fun fetchData(): String {
    delay(1000L) // Simulate a network or long-running task
    return "Data fetched!"
}

fun main() {
    println("Main starts: [${Thread.currentThread().name}]")

    runBlocking { // Synchronous coroutine
        println("Fetching data... [${Thread.currentThread().name}]")
        val data = fetchData() // Call suspend function
        println(data) // Output: "Data fetched!"
    }

    println("Main ends: [${Thread.currentThread().name}]")
}

```

## Asynchronous Coroutine Builders

Asynchronous coroutine builders are used to start coroutines that run concurrently. They are used for fire-and-forget tasks (`launch`), or tasks with results (`async`).

Examples:

The selected code uses asynchronous coroutine builders. Specifically, it uses the launch builder to start a coroutine that runs concurrently without blocking the main thread. The runBlocking function is used to bridge the blocking code and coroutines, but the coroutine itself is asynchronous.
```kotlin
fun main() {
    runBlocking {
        val job = launch {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        job.join()
    }
}
```

This code demonstrates the use of Kotlin coroutines to perform asynchronous operations. Here's a brief explanation:  
- GlobalScope.launch: Starts a new coroutine in the global scope.
- async: Starts a new coroutine and returns a Deferred result.
- delay(1000L): Suspends the coroutine for 1 second without blocking the thread.
- result.await(): Waits for the result of the async coroutine.
- Thread.sleep(2000L): Blocks the main thread for 2 seconds to allow the coroutine to complete.
- println: Prints the output to the console.
```kotlin 
fun main() {
    GlobalScope.launch {
        val result = async {
            delay(1000L)
            "World!"
        }
        println("Hello, ${result.await()}")
    }
    Thread.sleep(2000L)
}
```

This code demonstrates the use of Kotlin coroutines to perform asynchronous operations. Here's a brief explanation:  
- GlobalScope.launch: Starts a new coroutine in the global scope.
- launch: Starts a new coroutine within the GlobalScope.launch coroutine.
- delay(1000L): Suspends the coroutine for 1 second without blocking the thread.
- job.join(): Waits for the inner coroutine to complete.
- Thread.sleep(2000L): Blocks the main thread for 2 seconds to allow the coroutine to complete.
- The code prints "Hello," immediately and "World!" after a 1-second delay.
```kotlin 
fun main() {
    GlobalScope.launch {
        val job = launch {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        job.join()
    }
    Thread.sleep(2000L)
}
```

This code demonstrates the use of Kotlin coroutines to perform asynchronous operations. Here's a brief explanation:  
- runBlocking: Blocks the main thread until all coroutines inside it complete.
- async: Starts a new coroutine and returns a Deferred result.
- delay(1000L): Suspends the coroutine for 1 second without blocking the thread.
- result.await(): Waits for the result of the async coroutine.
- The code prints "Hello, World!" after a 1-second delay.
```kotlin
fun main() {
    runBlocking {
        val result = async {
            delay(1000L)
            "World!"
        }
        println("Hello, ${result.await()}")
    }
}
```
To try some examples, refer to the following links:
- [SuspendingFunctions.kt](SuspendingFunctions.kt)
- [SynchronousCoroutines.kt](SynchronousCoroutines.kt)
- [AsynchronousCoroutineBuilders.kt](AsynchronousCoroutineBuilders.kt)
- [SynchronousVsAsynchronous.kt](SynchronousVsAsynchronous.kt)

## Resources
- [Kotlin Playground](https://play.kotlinlang.org/)
- [Kotlin Coroutines Guide](https://kotlinlang.org/docs/coroutines-guide.html)
- [Kotlin Coroutines on Android](https://developer.android.com/kotlin/coroutines)


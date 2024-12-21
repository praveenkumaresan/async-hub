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

### Examples:

#### Example 1: Fetching Data

The following code demonstrates the use of a suspending function in Kotlin coroutines:

- `suspend fun fetchData()`: Defines a suspending function that simulates a long-running task by delaying for 1 second and then returning a string.
- `runBlocking`: Blocks the main thread until all coroutines inside it complete.
- The output shows sequential execution: "Fetching data..." followed by "Data fetched!".

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

### Example 2: Concurrent Tasks with `async`

This example demonstrates calling two suspending functions concurrently using `async`:

- **`fetchUserData`** and **`fetchOrders`**: Simulate network calls using suspending functions.
- **`async`**: Starts both tasks concurrently.
- **`await`**: Retrieves results sequentially after both tasks complete.

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

### Synchronous Coroutines

Synchronous coroutines are used to bridge blocking code and coroutines. They are commonly used in main functions or test cases.

#### Key Points:
- **`runBlocking`**: Blocks the main thread until all coroutines inside it complete.
- **`fetchData`**: Simulates a network or long-running task.
- The code demonstrates how synchronous coroutines wait for tasks to complete sequentially.

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

---

### Example 1: `launch` with `runBlocking`

The following code demonstrates the use of the `launch` builder to start a coroutine that runs concurrently without blocking the main thread. The `runBlocking` function bridges the blocking code and coroutines, but the coroutine itself is asynchronous.

```kotlin
fun main() {
    runBlocking {
        val job = launch {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        job.join() // Wait for the coroutine to complete
    }
}
```

#### Explanation:
- **`runBlocking`**: Blocks the main thread until all coroutines inside it complete.
- **`launch`**: Starts a coroutine for fire-and-forget tasks.
- **`job.join()`**: Waits for the coroutine to complete.
- **`delay`**: Suspends the coroutine for 1 second without blocking the thread.

### Example 2: Using `GlobalScope.launch` and `async`

This code demonstrates the use of `GlobalScope.launch` to start a coroutine in the global scope and the `async` builder to return a `Deferred` result.

```kotlin
fun main() {
    GlobalScope.launch {
        val result = async {
            delay(1000L)
            "World!"
        }
        println("Hello, ${result.await()}")
    }
    Thread.sleep(2000L) // Block the main thread to allow the coroutine to finish
}
```

#### Explanation:
- **`GlobalScope.launch`**: Starts a new coroutine in the global scope.
- **`async`**: Starts another coroutine and returns a `Deferred` result.
- **`delay`**: Suspends the coroutine for 1 second without blocking the thread.
- **`result.await()`**: Waits for the result of the `async` coroutine.
- **`Thread.sleep`**: Blocks the main thread for 2 seconds to allow coroutines to complete.


#### Key Points:
- This code demonstrates fire-and-forget behavior with **`GlobalScope.launch`** and a concurrent task with **`async`**.
- The use of **`Thread.sleep`** is required here because **`GlobalScope.launch`** is not tied to the lifecycle of the main thread. Without it, the program would exit before the coroutine completes.


### Example 3: Nested `launch` with `GlobalScope`

The following example demonstrates the use of nested `launch` coroutines within the `GlobalScope.launch`.

```kotlin
fun main() {
    GlobalScope.launch {
        val job = launch {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        job.join() // Wait for the nested coroutine to complete
    }
    Thread.sleep(2000L) // Block the main thread to allow the coroutine to finish
}
```
#### Explanation:
- **`GlobalScope.launch`**: Starts a top-level coroutine.
- **`launch`**: Creates a nested coroutine within the outer coroutine.
- **`delay`**: Suspends the nested coroutine for 1 second.

#### Key Points:
- The **`GlobalScope.launch`** starts a coroutine that operates independently of the main thread.
- The nested **`launch`** coroutine executes after being suspended for 1 second due to **`delay`**.
- The **`job.join()`** ensures that the nested coroutine completes before continuing with the outer coroutine's execution.
- The use of **`Thread.sleep`** ensures that the program does not terminate before the coroutines complete.



### Example 4: Using `async` with `runBlocking`

This example demonstrates the use of `async` within the `runBlocking` block to run tasks concurrently and wait for their results.

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

#### Explanation:
- **`runBlocking`**: Blocks the main thread until all coroutines inside it complete.
- **`async`**: Starts a coroutine and returns a `Deferred` result.
- **`delay`**: Suspends the coroutine for 1 second.
- **`result.await()`**: Waits for the result of the `async` coroutine.

#### Key Points:
- The **`runBlocking`** block ensures that the main thread waits for the coroutine to finish.
- The **`async`** coroutine runs concurrently, and its result is retrieved using **`await()`**.
- This approach is useful for tasks where you need to fetch results from concurrent operations.


To try some examples, refer to the following links:

- [SuspendingFunctions.kt](SuspendingFunctions.kt)
- [SynchronousCoroutines.kt](SynchronousCoroutines.kt)
- [AsynchronousCoroutineBuilders.kt](AsynchronousCoroutineBuilders.kt)
- [SynchronousVsAsynchronous.kt](SynchronousVsAsynchronous.kt)

## Resources

- [Kotlin Playground](https://play.kotlinlang.org/)
- [Kotlin Coroutines Guide](https://kotlinlang.org/docs/coroutines-guide.html)
- [Kotlin Coroutines on Android](https://developer.android.com/kotlin/coroutines)


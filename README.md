# async-hub learning path on Asynchronous programming


## What is Asynchronous programming?

Asynchronous programming is a means of parallel programming in which a unit of work runs separately from the main application thread and notifies the calling thread of its completion, failure or progress.

## What are the available options for Asynchronous programming?

Asynchronous programming can be achieved using the following options:

1. Callbacks
2. Promises
3. Async/Await (Coroutines)
4. Observables
5. Generators

## What is the difference between Synchronous and Asynchronous programming?

Synchronous programming is the default for most developers. It means that code is executed in sequence - each statement waits for the previous statement to finish before executing. Asynchronous programming allows a program to perform other tasks while waiting for long-running tasks to complete without freezing the program.

## What are the benefits of Asynchronous programming?

1. Improved Responsiveness
2. Improved Performance
3. Simplified Programming
4. Improved Scalability
5. Improved Resource Management
6. Improved User Experience

## What are the drawbacks of Asynchronous programming if not implemented correctly?

1. Debugging
2. Error Handling
3. Complexity
4. Callback Hell
5. Uncaught Exceptions
6. Deadlocks

## What are the best practices for Asynchronous programming?

There are many, listing few of them:
1. Use Promises
2. Use Async/Await
3. Use Generators
4. Use Observables
5. Use Callbacks
6. Use Throttling
7. Use Debouncing
8. Use Error Handling

## What are the common use cases for Asynchronous programming?

There are many, listing few of them:
1. Network Requests
2. File System Operations
3. Database Operations
4. User Input
5. Timers
6. Event Listeners
7. Web Workers

## What are the tools available for Asynchronous programming?

There are many, listing few of them:
1. Node.js
2. JavaScript
3. Python
4. Java
5. C#
6. C++
7. Ruby
8. PHP
9. Swift
10. Kotlin

## What are the best practices for Asynchronous programming in Kotlin?

There are many, listing few of them:
1. Use Coroutines
2. Use Flow
3. Use Channels
4. Use Actors
5. Use Structured Concurrency
6. Use Coroutine Context
7. Use Coroutine Builders
8. Use Coroutine Scopes
9. Use Coroutine Dispatchers
10. Use Coroutine Cancellation

## Fundamentals

- Refer to the [what is a coroutine in Kotlin and how it is different from a thread](src/main/kotlin/com/example/fundamentals/CoroutineVsThread.md) for a comparison of coroutines and threads.
- Refer to the [Comparison of Concepts](src/main/kotlin/com/example/fundamentals/ComparisonOfConcepts.md) for a comparison of synchronous and asynchronous programming in Kotlin.

## Advanced

Here are the links to each of the Kotlin examples:

- [CoroutineWithChannel.kt](src/main/kotlin/com/example/coroutines/CoroutineWithChannel.kt)
- [CoroutineMultipleThreads.kt](src/main/kotlin/com/example/coroutines/CoroutineMultipleThreads.kt)
- [CoroutineWithAsyncAwait.kt](src/main/kotlin/com/example/coroutines/CoroutineWithAsyncAwait.kt)
- [CoroutineWithFlow.kt](src/main/kotlin/com/example/coroutines/CoroutineWithFlow.kt)
- [CoroutineWithLaunch.kt](src/main/kotlin/com/example/coroutines/CoroutineWithLaunch.kt)
- [CoroutineWithRunBlocking.kt](src/main/kotlin/com/example/coroutines/CoroutineWithRunBlocking.kt)
- [CoroutineWithScope.kt](src/main/kotlin/com/example/coroutines/CoroutineWithScope.kt)
- [CoroutineWithStructuredConcurrency.kt](src/main/kotlin/com/example/coroutines/CoroutineWithStructuredConcurrency.kt)
- [CoroutineWithSuspendFunction.kt](src/main/kotlin/com/example/coroutines/CoroutineWithSuspendFunction.kt)
- [CoroutineWithTimeout.kt](src/main/kotlin/com/example/coroutines/CoroutineWithTimeout.kt)
- [CoroutineWithContext.kt](src/main/kotlin/com/example/coroutines/CoroutineWithContext.kt)
- [CoroutineWithMultipleUsers.kt](src/main/kotlin/com/example/coroutines/CoroutineWithMultipleUsers.kt)
- [CoroutineWithMultipleUsersDifferentThread.kt](src/main/kotlin/com/example/coroutines/CoroutineWithMultipleUsersDifferentThread.kt)
Structured concurrency in Kotlin ensures predictable and manageable coroutine execution by tying coroutines to a
well-defined scope. It simplifies lifecycle management, promotes error propagation, and avoids resource leaks, making
concurrent programming safer and easier to work with.

### Comparison: Structured vs. Unstructured Concurrency

| **Feature**              | **Structured Concurrency**                        | **Unstructured Concurrency**                                    |
|--------------------------|---------------------------------------------------|-----------------------------------------------------------------|
| **Lifecycle Management** | Coroutines are tied to a scope and its lifecycle. | Coroutines are independent, making lifecycle management manual. |
| **Error Handling**       | Parent cancels children on failure.               | Errors must be handled manually for each coroutine.             |
| **Resource Safety**      | Resources are released when the scope ends.       | Risk of memory/resource leaks.                                  |
| **Readability**          | Clear hierarchy and scope relationships.          | Harder to follow due to lack of structure.                      |


### Key Benefits of Structured Concurrency

- **Simplified Lifecycle Management**:
    - Coroutines are automatically canceled when the scope they are tied to is canceled.

- **Exception Handling**:
    - Exceptions are propagated in a predictable manner, making error handling easier.

- **Readability**:
    - Coroutines are tied to a hierarchy, making the flow of execution easier to follow.

- **Avoid Resource Leaks**:
    - Coroutines are automatically cleaned up when their scope ends, preventing memory/resource leaks.

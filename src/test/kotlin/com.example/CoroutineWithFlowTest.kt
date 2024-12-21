package com.example

import com.example.coroutines.simpleFlow
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CoroutineWithFlowTest {

    @Test
    fun testSimpleFlow() = runBlocking {
        val expectedValues = listOf(1, 2, 3, 4, 5)
        val emittedValues = mutableListOf<Int>()

        simpleFlow().collect { value ->
            emittedValues.add(value)
        }

        assertEquals(expectedValues, emittedValues)
    }
}
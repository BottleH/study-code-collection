package com.bottleh.studycodecollection.kotlin.chap15

import com.bottleh.studycodecollection.kotlin.chap12.remove
import com.bottleh.studycodecollection.kotlin.chap14.log
import com.bottleh.studycodecollection.kotlin.chap5.alphabet
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.coroutines.yield
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

suspend fun generateValue(): Int {
    delay(500.milliseconds)
    return Random.nextInt(0, 10)
}

suspend fun computeSum() {
    log("Computing a sum...")
    val sum = coroutineScope {
        val a = async { generateValue() }
        val b = async { generateValue() }
        a.await() + b.await()
    }
    log("Sum is $sum")
}

class ComponentWithScope(dispatcher: CoroutineDispatcher = Dispatchers.Default) {
    private val scope = CoroutineScope(dispatcher + SupervisorJob())

    fun start() {
        log("Starting")
        scope.launch {
            while (true) {
                delay(500.milliseconds)
                log("Component working!")
            }
        }
        scope.launch {
            log("Doing a one-off task...")
            delay(500.milliseconds)
            log("Task done!")
        }
    }

    fun stop() {
        log("Stopping!")
        scope.cancel()
    }
}

suspend fun calculateSomething(): Int {
    delay(3.seconds)
    return 2 + 2
}

suspend fun doCpuHeavyWork(): Int {
    var counter = 0
    val startTime = System.currentTimeMillis()
    while (System.currentTimeMillis() < startTime + 500) {
        counter++
        yield()
    }
    return counter
}

fun main() {
    runBlocking {
        launch {
            repeat(3) {
                doCpuHeavyWork()
            }
        }
        launch {
            repeat(3) {
                doCpuHeavyWork()
            }
        }
    }
}
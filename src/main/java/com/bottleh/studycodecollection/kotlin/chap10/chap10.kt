package com.bottleh.studycodecollection.kotlin.chap10

import java.io.BufferedReader
import java.io.FileReader
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import kotlin.io.path.Path
import kotlin.io.path.useLines

inline fun <T> synchronized(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        return action()
    }
    finally {
        lock.unlock()
    }
}

class LockOwner(val lock: Lock) {
    fun runUnderLock(body: () -> Unit) {
        synchronized(lock, body)
    }
}

inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) {
    //..
}

data class Person(val name: String, val age: Int)

val people = listOf(Person("Alice", 29), Person("Bob", 31))

fun lookForAlice(people: List<Person>) {
    people.forEach (fun (person) {
        if (person.name == "Alice") return
        println("${person.name} is not Alice")
    })
}

fun readFirstLineFromFile(fileName: String): String {
    Path(fileName).useLines {
        return it.first()
    }
}

fun main() {
    println(
        people.filter { it.age < 30 }
            .map(Person::name)
    )
}
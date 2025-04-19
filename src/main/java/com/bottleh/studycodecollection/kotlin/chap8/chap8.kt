package com.bottleh.studycodecollection.kotlin.chap8

import java.io.File

val i: Int = 1

data class Person(val name: String, val age: Int? = null) {
    fun isOlderThan(other: Person): Boolean? {
        if (age == null || other.age == null) {
            return null
        }
        return age > other.age
    }
}

val answer: Any = 42

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

fun readNumbers(text: String): List<Int?> {
    val result = mutableListOf<Int?>()
    for (line in text.lineSequence()) {
        val numberOrNull = line.toIntOrNull()
        result.add(numberOrNull)
    }
    return result
}

fun readNumbers2(text: String): List<Int?> = text.lineSequence().map { it.toIntOrNull() }.toList()

fun addValidNumbers(numbers: List<Int?>) {
    val validNumbers = numbers.filterNotNull()
    println("Sum of valid numbers: ${validNumbers.sum()}")
    println("Invalid numbers: ${numbers.size - validNumbers.size}")
}

fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>) {
    for (item in source) {
        target.add(item)
    }
}

fun printInUpperCase(list: List<String>) {
    println(CollectionUtils.upperCaseAll(list))
    println(list.first())
}

class FileIndexer : FileContentProcessor {
    override fun processContents(path: File, binaryContents: ByteArray?, textContents: MutableList<String>?) {
        TODO("Not yet implemented")
    }
}

class PersonParser : DataParser<Person> {
    override fun parseData(input: String, output: MutableList<Person>, errors: MutableList<String?>) {
        TODO("Not yet implemented")
    }
}

val fiveZeros = IntArray(5)
val fiveZerosToo = intArrayOf(0, 0, 0, 0, 0)

fun main() {
    val squares = IntArray(5) { i -> (i + 1) * (i + 1) }
    println(squares.joinToString())
}
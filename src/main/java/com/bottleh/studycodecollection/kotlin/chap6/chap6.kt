package com.bottleh.studycodecollection.kotlin.chap6

data class Person(val name: String, val age: Int)

val canBeInClub27 = { p: Person -> p.age <= 27 }
val temperatures = listOf(27.7, 29.8, 22.0, 35.5, 19.1)

class Book(val title: String, val authors: List<String>)

val library = listOf(
    Book("Kotlin in Action", listOf("Isakova", "Elizarov", "Aigner", "Jemerov")),
    Book("Atomic Kotlin", listOf("Eckel", "Isakova")),
    Book("The Three-Body Problem", listOf("Liu"))
)
fun main() {
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())
    // 5050
}
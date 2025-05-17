package com.bottleh.studycodecollection.kotlin.chap11

import kotlin.random.Random
import kotlin.reflect.KClass

fun <T : Number> oneHalf(value: T): Double {
    return value.toDouble()
}

fun <T : Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}

fun <T> ensureTrailingPeriod(seq: T) where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
}

class Processor<T : Any> {
    fun process(value: T) {
        value.hashCode()
    }
}

fun readNumbersOrWords(): List<Any> {
    val input = readln()
    val words: List<String> = input.split(",")
    val numbers: List<Int> = words.mapNotNull { it.toIntOrNull() }
    return numbers.ifEmpty { words }
}

fun printSum(c: Collection<Int>) {
    when (c) {
        is List<Int> -> println("List sum: ${c.sum()}")
        is Set<Int> -> println("Set sum: ${c.sum()}")
    }
}

inline fun <reified T> isA(value: Any) = value is T

inline val <reified T> T.canonical: String
    get() = T::class.java.canonicalName

fun printContents(list: List<Any>) {
    println(list.joinToString())
}

fun addAnswer(list: MutableList<Any>) {
    list.add(42)
}

interface Producer<out T> {
    fun produce(): T
}

open class Animal {
    fun feed() {
        //
    }
}

class Cat : Animal() {
    fun cleanLitter() {
        //
    }
}

class Herd<out T : Animal>(private var leadAnimal: T, vararg animals: T) {}

sealed class Fruit {
    abstract val weight: Int
}

data class Apple(override val weight: Int, val color: String) : Fruit()

data class Orange(override val weight: Int, val juicy: Boolean) : Fruit()

fun <T> copyData(source: MutableList<T>, destination: MutableList<in T>) {
    for (item in source) destination.add(item)
}

fun <T> printFirst(list: List<T>) {
    if (list.isNotEmpty()) {
        println(list.first())
    }
}

interface FieldValidator<in T> {
    fun validate(input: T): Boolean
}

object DefaultStringValidator : FieldValidator<String> {
    override fun validate(input: String) = input.isNotEmpty()
}

object DefaultIntValidator : FieldValidator<Int> {
    override fun validate(input: Int) = input >= 0
}

object Validators {
    private val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()

    fun <T : Any> registerValidator(kClass: KClass<T>, fieldValidator: FieldValidator<T>) {
        validators[kClass] = fieldValidator
    }

    @Suppress("UNCHECKED_CAST")
    operator fun <T : Any> get(kClass: KClass<T>): FieldValidator<T> =
        validators[kClass] as? FieldValidator<T> ?: throw IllegalArgumentException(
            "No validator for ${kClass.simpleName}"
        )
}

typealias NameCombiner = (String, String, String, String) -> String

val authorsCombiner: NameCombiner = { a, b, c, d -> "$a et al." }
val bandCombiner: NameCombiner = { a, b, c, d -> "$a, $b & The Gang" }

fun combineAuthors(combiner: NameCombiner) {
    println(combiner("Sveta", "Seb", "Dima", "Roman"))
}

fun main() {
    combineAuthors(bandCombiner)
    combineAuthors(authorsCombiner)
    combineAuthors { a, b, c, d -> "$d, $c & Co." }
}
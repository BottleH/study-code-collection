package com.bottleh.studycodecollection.kotlin.chap13

import kotlinx.html.*
import kotlinx.html.stream.createHTML
import org.hibernate.mapping.Table
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

fun buildString(
    builderAction: StringBuilder.() -> Unit
): String {
    val sb = StringBuilder()
    sb.builderAction()
    return sb.toString()
}

val appendExcl: StringBuilder.() -> Unit =
    { this.append("!") }

fun builderString(builderAction: StringBuilder.() -> Unit): String =
    StringBuilder().apply(builderAction).toString()

fun createSimpleTable() = createHTML().table {
    this@table.tr {
        (this@tr).td {
            +"cell"
        }
    }
}

@DslMarker
annotation class HtmlTagMarker

fun buildBookList() = createHTML().body {
    listWithToc {
        item(
            "The Three-Body Problem",
            "The Three-Body Problem is a classic physics problem from the early 20th century."
        )
        item(
            "The Cartesian Product Problem",
            "The Cartesian product is a useful mathematical construct for a wide variety of problems."
        )
        item(
            "The Conjugation Problem",
            "The Conjugation Problem is a classic computational problem from the 1970s."
        )

    }
}

@HtmlTagMarker
class LISTWITHTOC {
    val entries = mutableListOf<Pair<String, String>>()
    fun item(headline: String, body: String) {
        entries += headline to body
    }
}

fun BODY.listWithToc(block: LISTWITHTOC.() -> Unit) {
    val listWithToc = LISTWITHTOC()
    listWithToc.block()
    ul {
        for ((index, entry) in listWithToc.entries.withIndex()) {
            li {
                a("#${index}") { +entry.first }
            }
        }
    }
    for ((index, entry) in listWithToc.entries.withIndex()) {
        h2 { id = "$index"; +entry.first }
        p { +entry.second }
    }
}

class Greeter(val greeting: String) {
    operator fun invoke(name: String) {
        println("$greeting, $name!")
    }
}

class DependencyHandler {
    fun implementation(coordinate: String) {
        println("Added dependency on $coordinate")
    }

    operator fun invoke(body: DependencyHandler.() -> Unit) {
        body()
    }
}

val Int.days: Duration
    get() = this.toDuration(DurationUnit.DAYS)

val Int.hours: Duration
    get() = this.toDuration(DurationUnit.HOURS)

fun main() {
    val dependencies = DependencyHandler()
    dependencies.implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.5.0")
    }
}
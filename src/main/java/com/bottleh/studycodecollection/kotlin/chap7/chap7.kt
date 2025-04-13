package com.bottleh.studycodecollection.kotlin.chap7

import org.aspectj.lang.annotation.Before

fun strLen(s: String) = s.length

class Employee(val name: String, val manager: Employee?)

fun managerName(employee: Employee): String? = employee.manager?.name

fun greet(name: String?) {
    val recipient: String = name ?: "unnamed"
    println("Hello, $recipient")
}

fun strLenSafe(s: String?): Int = s?.length ?: 0

class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val firstName: String, val lastName: String) {
    override fun equals(o: Any?): Boolean {
        val otherPerson = o as? Person ?: return false

        return otherPerson.firstName == firstName && otherPerson.lastName == lastName
    }

    override fun hashCode(): Int = firstName.hashCode() * 37 + lastName.hashCode()
}

fun ignoreNulls(str: String?) {
    val strNotNull: String = str!! // 예외는 이 지점을 가리킨다.
    println(strNotNull.length)
}

class SelectableTextList(
    val contents: List<String>,
    var selectedIndex: Int? = null
)

class CopyRowAction(val list: SelectableTextList) {
    fun isActionEnabled(): Boolean = list.selectedIndex != null
    fun executeCopyRow() {
        val index = list.selectedIndex!!
        val value = list.contents[index]
    }
}

fun sendEmailTo(email: String) {
    println("Sending email to $email")
}

fun verifyUserInput(input: String?) {
    if (input.isNullOrBlank()) {
        println("Please fill in the required fields")
    }
}

fun <T: Any> printHashCode(t: T) {
    println(t.hashCode()) // 안전한 호출 사용
}
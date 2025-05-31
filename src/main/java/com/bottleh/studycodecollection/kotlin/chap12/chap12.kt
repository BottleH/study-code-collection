package com.bottleh.studycodecollection.kotlin.chap12

import org.springframework.cglib.core.ClassInfo
import java.sql.DriverManager.println
import java.util.*
import kotlin.reflect.KClass


@Deprecated("Use removeAt(index) instead.", ReplaceWith("removeAt(index)"))
fun remove(index: Int) {
}

@JvmName("performCalculation")
fun calculate(): Int {
    return (2 + 2) - 1
}

class CertificateManager {
    @get:JvmName("obtainCertificate")
    @set:JvmName("putCertificate")
    var certificate: String = "-----BEGIN CERTIFICATE-----"
}

@Target(AnnotationTarget.PROPERTY)
annotation class JsonExclude

annotation class JsonName(val name: String)

@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class BindingAnnotation

@BindingAnnotation
annotation class MyBinding

interface Company {
    val name: String
}

data class CompanyImpl(override val name: String) : Company

annotation class DeserializeInterface(val targetClass: KClass<out Any>)

interface ValueSerializer<T> {
    fun toJsonValue(value: T): Any?
    fun fromJsonValue(jsonValue: Any?): T
}

fun foo(x: Int) = println(x)

fun sum(x: Int, y: Int) = x + y

var counter = 0

fun main() {
    val kProperty = ::counter
    kProperty.setter.call(21)
    println(kProperty.get())
}


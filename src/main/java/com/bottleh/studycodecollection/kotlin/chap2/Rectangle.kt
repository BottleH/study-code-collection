package com.bottleh.studycodecollection.kotlin.chap2

class Rectangle(var height: Int, var width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

fun createUnitSquare(): Rectangle {
    return Rectangle(1, 1)
}
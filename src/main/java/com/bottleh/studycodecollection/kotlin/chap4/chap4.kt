package com.bottleh.studycodecollection.kotlin.chap4

import java.io.File
import java.io.Serializable
import java.net.URI

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable!")

}

open class RichButton : Clickable {
    final override fun click() {}
}

abstract class Animated { // 추상클래스의 인스턴스 만들 수 없음.
    abstract val animationSpeed: Double // 추상 프로퍼티: 하위 클래스는 반드시 값이나 접근자 제공
    val keyframes: Int = 20
    open val frames: Int = 60

    abstract fun animate() // 추상함수: 하위 클래스는 반드시 오버라이드해야함.
    open fun stopAnimating() {}
    fun animateTwice() {}
}

interface State : Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class Button : View {
    override fun getCurrentState(): State = ButtonState()
    override fun restoreState(state: State) {}
    class ButtonState : State {}
}

class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}

sealed class Expr
class Num(val value: Int) : Expr()
class Sum(val left: Expr, val right: Expr) : Expr()

fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
    }

sealed interface Toggleable {
    fun toggle()
}

class LightSwitch : Toggleable {
    override fun toggle() = println("Lights!")
}

class Camera : Toggleable {
    override fun toggle() = println("Camera!")
}

class Secretive private constructor(private val agentName: String) {}

open class Downloader {
    constructor(url: String?) {}

    constructor(uri: URI?) {}
}

class LengthCounter {
    var counter: Int = 0
        private set // 클래스 밖에서 이 프로퍼티의 값을 바꿀 수 없다.

    fun addWord(word: String) {
        counter += word.length
    }
}

class DelegatingCollection<T>(innerList: Collection<T> = mutableListOf<T>()) : Collection<T> by innerList

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

class MyClass {
    companion object {
        fun callMe() {
            println("Companion object called")
        }
    }
}

@JvmInline
value class UsdCent(val amount: Int)

fun addExpense(expense: UsdCent) {
    // 비용을 미국 달러의 센트 단위로 저장
}
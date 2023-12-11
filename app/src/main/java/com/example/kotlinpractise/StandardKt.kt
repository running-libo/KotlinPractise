package com.example.kotlinpractise

import java.io.File

//标准函数

/**
 * 手写 apply 函数
 */
inline fun <I> I.apply(block: I.() -> Unit): I {  //I.()表示把对象this传入到方法中
    block()
    return this //this == I == 调用者本身
}

/**
 * 手写 run 函数
 */
inline fun <T, R> T.run(block: T.() -> R): R {  // R泛型用来定义你自己决定返回的类型
    return block()
}

inline fun <T, R> myWith(t: T, use:(T)-> R): R {
    return use(t)
}

/**
 * 手写filter
 */
inline fun <T> Iterable<T>.myFilter(predicate:(T) -> Boolean): List<T> {
    var list = ArrayList<T>()

    for (item in this) {
        if (predicate(item)) {
            list.add(item)
        }
    }

    return list
}

/**
 * 手写 foreach 函数
 */
inline fun <E> Iterable<E>.mforEach(block: (E) -> Unit) {
    for (element: E in this) {
        block(element)
    }
}

fun stadardTest() {
    "lili".apply {
        println(this)
    }.apply {
        println(this.length)
    }

    File("").apply {
        if (!this.exists()) mkdirs()
    }.absolutePath

    listOf("数据1", "数据2", "数据3").mforEach {
        println("item: " + it)
    }

    "lili".run {
        println(this)
        "haha"
    }.run {
        println(this)
        println(this.length)
    }
}
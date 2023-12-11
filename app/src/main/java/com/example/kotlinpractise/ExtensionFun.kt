package com.example.kotlinpractise

class Persons(val name: String, val age: Int, val sex: Char)

//给类增加扩展函数
fun Persons.show() {
    println(name + "--" + age + "--" + sex)
}

//给字符串增加扩展函数
fun String.showStr() {
    println(this)
}

fun extensionTest() {
    Persons("lili", 18, '0').show()

    "当前日志打印".showStr()

    //扩展函数转java之后，就是给当前类新增一个静态方法，方法新增一个参数，把调用者这个类变量作为this参数，并传到方法中
//    class Persons {}
//        public static final void show(Persons $this$show) {
//
//        }
//    }
}

//泛型扩展函数

fun <T> T.showContentInfo() = println("${this.toString()}")
fun commonFun() {}

fun <INPUTTYPE> INPUTTYPE.showType() =
    when(this) {
        is String -> "你是String类型"
        is Int -> "你是Int类型"
        else -> "未知类型"
    }
fun extensionTest2() {
    345.showContentInfo()
    "sdfs".showContentInfo()
    false.showContentInfo()
    commonFun().showContentInfo() //函数也可以作为泛型

    println("hello".showType())
    println(345.showType())
}
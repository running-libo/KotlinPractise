package com.example.kotlinpractise.base

fun test() {
    //有参数默认值可不传，可选择性传
    action01("haha", 20)
    action02("lily")
    action03(age = 15)
    action03(name = "luky", age = 15)  //定义名字填写的参数，叫做具名函数参数
}

private fun action01(name: String, age: Int) {
    println("$name---$age")
}

private fun action02(name: String, age: Int = 18) { //参数的默认值
    println("$name---$age")
}

private fun action03(name: String = "hello", age: Int = 18) {
    println("$name---$age")
}

/**
 * Unit类型，不写默认也有， 无参数返回的忽略类型
 * 相当于java的void关键字，反编成java语言就是void
 * 但是void是关键字，Unit是类型
 */
private fun doWork() : Unit {
    println() //return可写可不写
//        return println()
}
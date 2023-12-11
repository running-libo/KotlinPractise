package com.example.kotlinpractise

class Person(val name: String) {
    var age = 0
    var sex = "man"

    constructor(): this("main name 1") {

    }

    /**
     * 无参次构造方法
     */
    constructor(name: String, age: Int) : this("main name 2") {
        this.age = age
    }
    /**
     * 有参次构造方法
     */
    constructor(name: String, sex: String): this("main name 3") {
        this.sex = sex;
    }

    init {
        println("name is $name")
        println("age is $age")
    }

    fun main() {
        Person("", "")
        Person("")
    }
}
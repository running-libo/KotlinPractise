package com.example.kotlinpractise.base

class lateinit {

    lateinit var request: String

    fun lateInitUse() {
        request = ""
        if (::request.isInitialized) {
            //判断lateinit属性是否已经初始化，没初始化使用会崩溃
            println("request已经初始化")
        } else {

        }
    }

    val sqlData: String by lazy {
        println("readData")
        println("readData")
        "read finish"
    }
}


/// ===的使用 : 表示引用的比较
fun equals() {
    val name1 = "lili"
    val name2 = "lili"
    println(name1 === name2) //这里返回ture，因为字符串在常量池是复用一份的
}
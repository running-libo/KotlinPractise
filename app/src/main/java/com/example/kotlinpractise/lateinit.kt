package com.example.kotlinpractise

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
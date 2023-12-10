package com.example.kotlinpractise.base

class lateinit {

    lateinit var request: String

    private fun lateInitUse() {
        if (::request.isInitialized) {
            //判断lateinit属性是否已经初始化，没初始化使用会崩溃
        } else {

        }
    }

    val sqlData: String by lazy {
        println("readData")
        println("readData")
        "read finish"
    }
}
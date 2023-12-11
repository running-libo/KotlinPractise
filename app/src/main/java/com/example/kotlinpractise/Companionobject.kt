package com.example.kotlinpractise

class Companionobject {

    //伴生对象的由来，是kotlin没有static静态
    //不管对象创建多少个，companion object只会初始化一次
    companion object {
        val info = "lili" //静态变量

        fun showInfo() {
            println(info)
        }
    }

    fun test() {
        //背后代码：生成了 Companionobject.companion类
        println(info)

        showInfo()
    }
}
package com.example.kotlinpractise.base

class OuterClass {

    val outerInfo: String = "outerInfo"

    fun show() {
        InnerClass().show() //外部类可以访问内部类
    }

    //加上inner关键字才是内部类，内部类才能和外部类相互访问，否则不是内部类而是嵌套类
    inner class InnerClass {
        fun show() = println("my outerclass info: " + outerInfo) //内部类也可以访问外部类
    }
}
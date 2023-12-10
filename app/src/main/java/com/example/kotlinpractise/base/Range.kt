package com.example.kotlinpractise.base

class Range {

    fun range(number: Int) {
        //range 范围
        if (number in 10..59) {
            println("不及格")
        } else if (number in 0 .. 9) {
            println("很差")
        } else if (number in 60..100) {
            println("及格")
        } else {
            println("分数不合法")
        }
    }

    fun whenTest() {
        val week = 5
        val info = when(week) {
            1 -> "星期一"
            1 -> "星期二"
            3 -> println()
            4 -> 5
            -1 -> TODO()  //Nothing类型：表示未实现的功能，会抛出异常 public inline fun TODO(): Nothing = throw NotImplementedError()
            else -> ""  //返回String类型，info一定是String类型
        }

        val info2 = when(week) {
            1 -> "星期一"
            2 -> "星期二"
            3 -> println()
            4 -> true
            in 2..5 ->
                ""
            else -> {  //必须要有else
                //else 返回括号，info2就可以是任意类型 Any
            }
        }
    }
}
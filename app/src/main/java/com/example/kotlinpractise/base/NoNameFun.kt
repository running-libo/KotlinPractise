package com.example.kotlinpractise.base

/**
 * 匿名函数
 */


fun noName() {
    val len = "lili".count()
    println(len)

    "lili".count {
        // it等价于 l  i  l  i元素，中间调用了一个predicate函数
        it == 'r'
    }
}

/**
 * 函数参数
 */
fun funParams() {
    //将函数类型和形参分开写
    val methodAction : (Int, Int, Int) -> String = { num1, num2, num3 ->
        var sum = num1 + num2 + num3
        "" +sum
    }

    //调用函数
    methodAction(1, 2, 3)
}

/**
 * 匿名函数的类型推断
 * 入参、返回类型不固定
 * 使用最后一行表达式推断类型
 */
fun funType() {

    //匿名函数类型推断为String
    //方法名 + 冒号: 方式必须指定参数类型和返回类型
    val method1: () -> String = {
        ""
    }

    method1()

    //方法名 = {}  方式自动推断返回类型，返回类型跟回返回可随时更改
    val method2 = { v1:Double, v2:Float, v3:Int ->
        ""  //可返回 String
        3423  //可返回 Int
        true //可返回boolean类型
        { a:Int ->  //可返回函数

        }
    }

    method2(23.3, 32.2f, 10)

    val method3 = {

    }
    method3() //无入参，无返回值类型

    val method4 = { number: Int ->
        number
    }
    var intNum = method4(8)
}
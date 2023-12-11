package com.example.kotlinpractise


/**
 * 惰性加载
 */
class Bylazy {

    val database = readSqlDataBase()

    val databaseLazy by lazy {
        readSqlDataBase()
    }

    private fun readSqlDataBase(): String {
        println("加载数据库数据...")
        return "加载完成"
    }
}

fun testbyLazy() {
    val bylazy = Bylazy()  //不使用by lazy，创建类对象，就会初始化database成员变量，就会直接调用readSqlDataBase()方法代码块

    Thread.sleep(5000)
    println(bylazy.database) //还没等到使用database，readSqlDataBase方法代码就被初始化了

    println(bylazy.databaseLazy) //databaseLazy的属性，当5秒之后使用才会加载
}
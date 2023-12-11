package com.example.kotlinpractise

class User(val name: String) { //主构造函数
    var age = 0
    var sex = "man"

    /**
     * 有参次构造方法
     */
    constructor(name: String, age: Int, id: Int): this(name) {  //次构造函数，必须去调用主构造

    }
    constructor(name: String, sex: String): this(name) {
        this.sex = sex
    }

    /**
     * 无参次构造方法
     */
    constructor(): this("暂无名字") {

    }

    init {
        println("name is $name")
        println("age is $age")
    }

    fun main() {
        User()   //次构造
        User("小明")  //主构造
        User("小明", 18, 1)  //次构造
    }

    //继承
    class VipUser : User(), Use {}

    open class User {}

    interface Use {}
}
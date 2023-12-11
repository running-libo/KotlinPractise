package com.example.kotlinpractise

//Kotlin基础使用

class Base {

    /**
     * 变量
     */
    fun variable() {
        var age: Int = 0
        var num = 20
        val TYPE: Int = 100
        var name: String = ""
    }

    //const val 需与 companion object 搭配使用
    companion object {
        const val VERSION = 1
    }

    /**
     * 空指针检查操作
     */
    fun nullable() {
        var info: String? = null

        println(info?.length)  //第一种补救：如果info为null，就不执行后面的.length代码

        println(info!!.length)  //第二种补救：这里如果为null，我自己负责info，会报出空指针，这种处理需慎用

        if (info != null) {   //第三种补救措施，如下这种同java写法
            println(info.length)
        }

        println(info?.length ?: "空数据")  //第四种补救措施，如果真的为null，则改为返回"空数据"
    }

    fun str() {
        fun stringFormat(title: String) = run { "这里是拼接字符串${title}" }  //字符串拼接

        //字符串自动换行
        val content = """ 
            哈哈哈哈
            呵呵呵呵
            嘿嘿嘿嘿
        """.trimIndent()
    }

    /// ===的使用 : 表示引用的比较
    fun equals() {
        val name1 = "lili"
        val name2 = "lili"
        println(name1 === name2) //这里返回ture，因为字符串在常量池是复用一份的

        //将条件判断的结果赋值
        val num1 = 100
        val num2 = 101
        val max = if (num1 > num2) num1 else num2
    }

    //object
    class SingleTon {
        object Holder {
            var instance = SingleTon()
        }
    }

    //is
    fun charge() {
        var type = ""
        if (type is String) {  //instanceOf

        }
    }

    //in使用
    fun isLetter(c: Char): Boolean = c in 'a'..'z' || c in 'A'..'Z'   //检查字符是否为字母

    //检查list中是否有元素name
    fun inList() {
        val names = listOf("lala", "haha", "yaya")
        if("lili" in names) {

        }
    }

    class User() {
        init {

        }
    }

    //数组
    fun createArray() {
        var names = arrayOf("小王", "小花", "小红", "小明")

        var ages = arrayOf(22, 19, 18)

        var array = arrayOfNulls<String>(5)   //创建空数组
        array.set(1, "哈哈")   //赋值
    }

    //数组遍历
    fun arrayForEach() {
        var names = arrayOf("小王", "小花", "小红", "小明")
        for (i in 1..5 step 1) {   //跳过第1步遍历

        }

        for (i in 0..names.size-1) {  //遍历names数组，相当于java里  for (int i=0:i<names.length;i++)

        }

        for (i in names.indices) {  //正序遍历

        }

        for (i in 1 until 10){    //为一个左闭右开的区间，打印1到9
            print("$i")
        }

        for (i in names.size downTo 0) {  //倒序遍历

        }

        for (i in names.reversed()) {  //反转遍历数组

        }

        repeat(10) {  //打印0到9
            print(it)
        }

        names.forEach {  //forEach函数遍历，Kotlin里的集合都自带foreach函数

        }

        names.forEachIndexed { index, s ->   //带position的遍历

        }
    }

}
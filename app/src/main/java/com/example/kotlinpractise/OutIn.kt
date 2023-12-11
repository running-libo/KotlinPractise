package com.example.kotlinpractise


//泛型类定义
class Generic<T> (private val obj: T) {  //需求： 万能输入器

    fun show() = println("输出：" + obj)
}

data class Student(val name: String, val age: Int, val sex: Char)
data class Teacher(val name: String, val age: Int, val sex: Char)

fun showGeneric() {
    val stu1 = Student("张三", 10 ,'0')
    val stu2 = Student("李四", 10 ,'0')
    val tea1 = Teacher("miss", 25, '1')

    Generic(stu1).show()
    Generic(stu2).show()
    Generic(tea1).show()
    Generic(String("lili".toByteArray())).show()
}


class Dinamic<T> (vararg objects: T) { //定义泛型的动态参数

    //out 我们的T只能被读取，不能被修改
    val objectArray: Array<out T> = objects //因为T为任意类型，需要集合承接，需要定义一个下界，即协变

    fun showObj(index: Int) : T ? = objectArray[index].takeIf { it is Int }
}

fun showVararg() {
    Dinamic(10, "haha", Student("", 1, '0')).showObj(0)
}


// Out In

//生产者  out T 协变  使用out T 数据就是只读的，不能被修改
interface Producer<out T> {

//    fun consumer(item: T)  //进行消费
//        //这里是out修饰T，无法对T对象进行操作使用，所以编译不通过

    fun producer(): T
}

//消费者 in T 逆变  使用in T 数据就是只读的，不能被修改
interface Consumer<in T> {
    fun consumer(item: T)

    //不能被读取 （编译不通过）
//    fun producer(): T
}

//生产者 & 消费者 T 默认情况下，是不变
interface ProducerAndConsumer <T> {
    fun consumer(item: T) //能被读取

    fun producer(): T //能被修改
}

open class Animal
open class Human: Animal()
class ProduceClass: Producer<Animal> {

    override fun producer(): Animal {
        println("生产者 Animal")
        return Animal()
    }
}
class ProduceClass2: Producer<Human> {

    override fun producer(): Human {
        println("生产者 Human")
        return Human()
    }
}

class ComsumerClass: Consumer<Animal> {

    override fun consumer(item: Animal) {
        println("消费者 Animal")
    }
}
class ComsumerClass2: Consumer<Human> {

    override fun consumer(item: Human) {
        println("消费者 Human")
    }
}

fun showOutIn() {
    //泛型默认情况是：泛型的子类对象 不可以赋值给 泛型的父类对象
//    List<CharSequence> list2 = new ArrayList<String>() //报错
//    List<? extends CharSequence> list2 = new ArrayList<String>() //正确 声明泛型是CharSequence或它的子类就可以


    val p1: Producer<Animal> = ProduceClass()
    val p2: Producer<Animal> = ProduceClass2() // ProduceClass2传递的是Human，因为 T是out修饰，对应java的 ? extend T,只要类型是Animal的子类都可以
    p2.producer()

    val c1: Consumer<Human> = ComsumerClass() //ComsumerClass传递的事Animal， 因为 T是in修饰，对应java的 ? super T，只要类型是Human的父类都可以
    c1.consumer(Human())
    val c2: Consumer<Human> = ComsumerClass2()
}
package com.example.kotlinpractise

class EnumSealed {
}

/**
 * 枚举定义单类型
 */
enum class Week {
    Sunday,
    Monday,
    Whensday,
    Twoesday,
    Thersday
}

fun enumTest() {
    println(Week.Sunday)
    println(Week.Whensday)

    //枚举的值等价于 枚举本身
    println(Week.Twoesday is Week)  //这里是true
}

//kotlin想表达枚举也是一个class，可以让枚举附带构造参数，有更丰富的功能
/**
 * 枚举定义函数类型
 */
enum class Limbs(val limbsInfo: LimbsInfo) {  //枚举主构造参数需要和枚举定义的参数数量类型一致
    LEFT_HAND(LimbsInfo("左手", 60)),
    RIGHT_HAND(LimbsInfo("右手", 60)),
    LEFT_FOOT(LimbsInfo("左脚", 80)),
    RIGHT_FOOT(LimbsInfo("右脚", 80));

    fun show() = "四肢是 ${limbsInfo.limbsInfo} 长度是： ${limbsInfo.length}"
}

class LimbsInfo(val limbsInfo: String, val length: Int) {
    fun show() {
        println(limbsInfo + "长度是:" + length)
    }
}

fun showEnumInfo() {
    println(Limbs.LEFT_HAND.show())
}


//密封类  sealed class ，成员必须有具体类型,且各类型可以不一致，且需要继承于自己  (Enum的成员是自己的类型)
sealed class Exam {
    // object类型，不需要任何成员
    // class类型，成员可有可没有
    // data class类型，必须要有成员
    object Fraction1 : Exam() //分数差
    object Fraction2 : Exam() //分数及格
    object Fraction3 : Exam() //分数良好
    class Fraction4(val studentName: String) : Exam() //分数优秀

    data class Fraction5(val studentName: String, val age: Int) : Exam()

    //需求： 得到成绩优秀的孩子姓名
}

class Teachers(private val exam: Exam) {
    fun show() = when(exam) {
        is Exam.Fraction1 -> "成绩很差"
        is Exam.Fraction2 -> "成绩及格"
        is Exam.Fraction3 -> "成绩良好"
        is Exam.Fraction4 -> "该学生 ${exam.studentName} 成绩优秀"  //得到密封类的变量
        is Exam.Fraction5 -> "该学生 ${exam.studentName} 成绩优秀，年龄 ${exam.age}"
    }
}

fun showSealedInfo() {
    println(Teachers(Exam.Fraction1).show())
    println(Teachers(Exam.Fraction2).show())
    println(Teachers(Exam.Fraction4("lily")).show())
    println(Teachers(Exam.Fraction4("libo")).show())
    println(Teachers(Exam.Fraction5("lala", 18)).show())
}

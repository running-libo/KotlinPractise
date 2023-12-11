package com.example.kotlinpractise

/**
 * 高阶函数
 * 高阶函数的实现是  匿名函数 或者 lambda表达式
 */

//模拟： 数据库 sqlserver

const val USER_NAME_DB = "lili"
const val USER_PWD_DB = "123456"

//登录API
/**
 * responseResult: 将校验结果返回给调用者
 */
fun loginApi(userName: String, userpwd: String, responseResult: (String, Int) -> Unit) {
    if (userName == null || userpwd == null) {
        TODO("用户名或者密码为空")
    }

    if (userName.length > 3 && userpwd.length > 3) {
        if (loginApiService(userName, userpwd)) {
            //登录成功
            responseResult("login success", 200)
        }
    } else {
        responseResult("login fail", 400)
        TODO("输入不合格")
        //登录失败
    }
}

private fun loginApiService(userName: String, userpwd: String): Boolean {
    return userName == USER_NAME_DB && userpwd == USER_PWD_DB
}

//函数类型作为返回类型

/**
 * 再定义一个登录函数，登录成功还会将用户名密码以函数的形式进行返回
 */
fun loginApi2(userName: String, userpwd: String, responseResult: (String, Int) -> Unit) : (String, Int) -> Boolean {
    if (userName == null || userpwd == null) {
        TODO("用户名或者密码为空")
    }

    if (userName.length > 3 && userpwd.length > 3) {
        if (loginApiService(userName, userpwd)) {
            //登录成功
            responseResult("login success", 200)
            return { msg: String, code: Int ->
                code == 200 //自行判断code是否登录成功
            }
        }
    }
    return { msg: String, code: Int ->
        false //自行判断code是否登录成功
    }
}

fun gotoLogin() {
    //同一个方法的不同种调用
    loginApi("lili", "123456", responseResult = { msg: String, code: Int ->
        println("最终登录结果 msg:$msg code:$code")
    })

    loginApi("lili", "123456", { msg, code->
        println("最终登录结果 msg:$msg code:$code")
    })

    //最简写方法，lambda表达式可以写到参数里面，也可以写到参数外面
    loginApi("lili", "123456") { msg, code ->
        println("最终登录结果 msg:$msg code:$code")
    }

    val bool = loginApi2("sfs", "123") { msg, code ->
        println("最终登录结果 msg:$msg code:$code")
    }

}

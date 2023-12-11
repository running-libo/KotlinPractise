package com.example.kotlinpractise

import androidx.compose.foundation.text.KeyboardActions

//kotlin的接口
//接口里面的所有成员和方法和接口本身都是 public open的
//实现类不仅要重写接口的函数，还要重写接口的成员
interface IUSB {
    var usbVersionInfo: String

    fun insertUSB(): String
}

//成员重写写到实现类的构造方法中 方式
class Mouse(override var usbVersionInfo: String = "USB 3.0") : IUSB {
    override fun insertUSB(): String = usbVersionInfo
}

//成员重写写到实现类中的方式
class KeyBorad: IUSB {
    override var usbVersionInfo: String = "USB 3.0"
        get() {  //get/set 方法会调用代码块内容，并返回一个值
            println("获取了 usbVersionInfo ${usbVersionInfo}")
            return field
        }
        set(value) {
            println("设置了 usbVersionInfo ${usbVersionInfo}")
            field = value //field表示该 usbVersionInfo 属性
        }

    override fun insertUSB(): String = "keyboard $usbVersionInfo"

}

fun showInterface() {
    val usb1 = Mouse()
    usb1.insertUSB()

    val usb2 = KeyBorad()
    usb2.usbVersionInfo = "sfd" //使用属性调用get()  赋值属性调用set()
    usb2.insertUSB()
}
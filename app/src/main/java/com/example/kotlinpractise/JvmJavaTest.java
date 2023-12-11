package com.example.kotlinpractise;

import java.util.List;

public class JvmJavaTest {

    public void getJvmFieldStatic() {
//        new Personz().getNames();  //没加 jvmField的调用
        List<String> names = new Personz().names; //加了 jvmField的调用

        //没加 JvmStatic，java调用 Companion object需要加一层 Companion类来调用
//        Personz.Companion.getName();
//        Personz.Companion.printlnPersonName();

        String name = Personz.name;
        //加上 JvmStatic，就有了和Kotlin一样的调用效果，把函数写到了 Companion类 外面
        Personz.printlnPersonName();
    }
}

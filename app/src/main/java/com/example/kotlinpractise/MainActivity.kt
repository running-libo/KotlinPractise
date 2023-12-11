package com.example.kotlinpractise

import android.os.Bundle
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lateinit().apply {
            sqlData
            lateInitUse()
        }

        Range().apply {
            range(64)
            whenTest()
        }

        initParams()

        noName()
        funParams()
        funType()

        gotoLogin()

        testbyLazy()

        OuterClass().show()

        showEnumInfo()
        showSealedInfo()

        showGeneric()

        showOutIn()

        extensionTest()
        extensionTest2()

        stadardTest()
    }
}
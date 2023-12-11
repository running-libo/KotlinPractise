package com.example.kotlinpractise

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.kotlinpractise.base.OuterClass
import com.example.kotlinpractise.base.Person
import com.example.kotlinpractise.base.Range
import com.example.kotlinpractise.base.funParams
import com.example.kotlinpractise.base.funType
import com.example.kotlinpractise.base.gotoLogin
import com.example.kotlinpractise.base.initParams
import com.example.kotlinpractise.base.lateinit
import com.example.kotlinpractise.base.noName
import com.example.kotlinpractise.base.showEnumInfo
import com.example.kotlinpractise.base.showSealedInfo
import com.example.kotlinpractise.base.testbyLazy

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Person()

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
    }
}
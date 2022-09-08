package com.example.common

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Point
import android.os.Bundle
import android.view.Window

class CustomDialog(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.common_dialog_custom)
        val window = window
//        window!!.setGravity(gravity)
//        window!!.setWindowAnimations(animId)
        // 宽度全屏
        // 宽度全屏
        val windowManager = (context as Activity).windowManager
        val display = windowManager.defaultDisplay
        val lp = window!!.attributes
        val p = Point()
        display.getSize(p)
        lp.width = p.x * 8 / 10 // 设置dialog宽度为屏幕的9/10

        getWindow()!!.attributes = lp

        initView()
    }

   private fun initView(){

   }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }
}
package com.example.common.utils

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.Toast
import java.lang.reflect.Field

@SuppressLint("SoonBlockedPrivateApi")
class ToastUtils private constructor() {
    init {
        try {
            sField_TN = Toast::class.java.getDeclaredField("mTN")
            sField_TN.isAccessible = true
            sField_TN_Handler = sField_TN.type.getDeclaredField("mHandler")
            sField_TN_Handler.isAccessible = true
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        private lateinit var sField_TN: Field
        private lateinit var sField_TN_Handler: Field
        private var mToast: Toast? = null //全局唯一的Toast

        /**
         * 取消Toast显示
         */
        @Suppress("UnPrivate")
        fun cancelToast() {
            mToast?.cancel()
        }

        /**
         * 短时间显示Toast
         *
         * @param context
         * @param message
         */
        fun showShort(context: Context, message: CharSequence) {
            cancelToast()
            mToast = Toast.makeText(context.applicationContext, message, Toast.LENGTH_SHORT)
            hook(mToast!!)
            mToast!!.show()
        }

        fun showShort(context: Context, resId: Int) {
            cancelToast()
            mToast = Toast.makeText(context.applicationContext, resId, Toast.LENGTH_SHORT)
            hook(mToast!!)
            mToast!!.show()
        }

        fun showShort(context: Context, str: String) {
            cancelToast()
            mToast = Toast.makeText(context.applicationContext, str, Toast.LENGTH_SHORT)
            hook(mToast!!)
            mToast!!.show()
        }

        /**
         * 长时间显示Toast
         *
         * @param context
         * @param message
         */

        fun showLong(context: Context, message: CharSequence) {
            cancelToast()
            mToast = Toast.makeText(context.applicationContext, message, Toast.LENGTH_SHORT)
            hook(mToast!!)
            mToast!!.show()
        }

        fun showLong(context: Context, resId: Int) {
            cancelToast()
            mToast = Toast.makeText(context.applicationContext, resId, Toast.LENGTH_SHORT)
            hook(mToast!!)
            mToast!!.show()
        }

        fun showLong(context: Context, str: String) {
            cancelToast()
            mToast = Toast.makeText(context.applicationContext, str, Toast.LENGTH_SHORT)
            hook(mToast!!)
            mToast!!.show()
        }


        /**
         * 自定义显示Toast时间
         *
         * @param context
         * @param message
         * @param duration 单位:毫秒
         */
        fun show(context: Context, message: CharSequence, duration: Int) {
            cancelToast()
            mToast = Toast.makeText(context.applicationContext, message, duration)
            hook(mToast!!)
            mToast!!.show()
        }

        fun show(context: Context, resId: Int, duration: Int) {
            cancelToast()
            mToast = Toast.makeText(context.applicationContext, resId, duration)
            hook(mToast!!)
            mToast!!.show()
        }

        fun show(context: Context, str: String, duration: Int) {
            cancelToast()
            mToast = Toast.makeText(context.applicationContext, str, duration)
            hook(mToast!!)
            mToast!!.show()
        }

        /**
         * 自定义Toast的View  已废弃,可用自定义dialog
         *
         * @param context
         * @param message
         * @param duration 单位:毫秒
         * @param view     显示自己的View
         */
        fun customToastView(context: Context, message: CharSequence, duration: Int, view: View) {
            cancelToast()
            mToast = Toast.makeText(context.applicationContext, message, duration)
            mToast!!.view = view
            hook(mToast!!)
            mToast!!.show()
        }


        private fun hook(toast: Toast) {
            if (Build.VERSION.SDK_INT == Build.VERSION_CODES.N_MR1) {
                try {
                    val tn = sField_TN.get(toast)
                    sField_TN_Handler.set(
                        tn,
                        SafelyHandlerWarpper(sField_TN_Handler.get(tn) as Handler)
                    )
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    class SafelyHandlerWarpper(private val impl: Handler) : Handler() {
        override fun dispatchMessage(msg: Message) {
            try {
                super.dispatchMessage(msg)
            } catch (e: java.lang.Exception) {
            }
        }

        override fun handleMessage(msg: Message) {
            impl.handleMessage(msg) //需要委托给原Handler执行
        }
    }


}
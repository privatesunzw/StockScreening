package com.example.stockscreening.utils

import android.content.Context
import android.content.Intent
import android.os.Parcelable

class MyRouter(var intent: Intent) {

    fun build(context: Context, cls: Class<*>):MyRouter{
        intent.setClass(context,cls)
        return this
    }

    fun withString(key:String,value: String):MyRouter{
        intent.putExtra(key,value)
        return this
    }
    fun withInt(key:String,value: Int):MyRouter{
        intent.putExtra(key,value)
        return this
    }

    fun withByte(key:String,value: Byte):MyRouter{
        intent.putExtra(key,value)
        return this
    }
    fun withChar(key:String,value: Char):MyRouter{
        intent.putExtra(key,value)
        return this
    }
    fun withShort(key:String,value: Short):MyRouter{
        intent.putExtra(key,value)
        return this
    }
    fun withLong(key:String,value: Long):MyRouter{
        intent.putExtra(key,value)
        return this
    }
    fun withFloat(key:String,value: Float):MyRouter{
        intent.putExtra(key,value)
        return this
    }
    fun withDouble(key:String,value: Double):MyRouter{
        intent.putExtra(key,value)
        return this
    }
    fun withCharSequence(key:String,value: CharSequence):MyRouter{
        intent.putExtra(key,value)
        return this
    }fun withParcelable(key:String,value: Parcelable):MyRouter{
        intent.putExtra(key,value)
        return this
    }

}
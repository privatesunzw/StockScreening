package com.example.common

import android.app.Application
import android.content.Context
import com.didi.drouter.router.IRouterInterceptor
import com.didi.drouter.router.Request

class CommonApplication : Application(),IRouterInterceptor{
    //    fun getInstance(): Context? {
//        return BaseApplication.getAppContext()
//    }
    override fun handle(request: Request) {
        TODO("Not yet implemented")
    }
}
package com.example.stockscreening.net



import okhttp3.ResponseBody
import retrofit2.Call


import retrofit2.http.GET
import retrofit2.http.Path


interface IServiceApi {

    // 获得股票信息接口
    @GET("q={code}")
    fun getStockData(@Path("code") code:String?): Call<ResponseBody>

}
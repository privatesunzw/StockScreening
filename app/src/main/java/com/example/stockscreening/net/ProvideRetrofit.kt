package com.example.stockscreening.net

import android.util.Log
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import okio.Buffer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Url
import java.io.IOException
import java.net.URLDecoder
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ProvideRetrofit {
    lateinit var retrofit: Retrofit
    lateinit var serviceApi:IServiceApi


    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        if(!this::retrofit.isInitialized){
            synchronized(ProvideRetrofit::class){
                if(!this::retrofit.isInitialized){
                    val builder = OkHttpClient.Builder()
                    // 估计是一种加密后续了解
                    // SSLSocketFactoryUtils.keyVerify(builder)
                    ////////////
                    builder.connectTimeout(60, TimeUnit.SECONDS)
                        .writeTimeout(60, TimeUnit.SECONDS)
                        .readTimeout(60, TimeUnit.SECONDS)
                        .retryOnConnectionFailure(true)
                    //           .addInterceptor(HttpBaseUrlInterceptor())     url拦截器
                    //           .addInterceptor(loggingInterceptor)            日志
                    //           .addInterceptor(ResponseActionIntercepter())   token失效拦截器
                    val okHttpClient = builder.build()

                    retrofit=Retrofit.Builder()
                        .baseUrl("http://qt.gtimg.cn/")       //主url拼接前半段
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(okHttpClient)
                        .build()
                }

            }

        }
        return retrofit
    }


    private fun createRetrofit():Retrofit{
        val builder = OkHttpClient.Builder()
        // 估计是一种加密后续了解
        // SSLSocketFactoryUtils.keyVerify(builder)
        ////////////
        val loggingInterceptor = HttpLoggingInterceptor { message ->
            Log.i("sssssssssssssss", message)
        }
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        builder.connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
 //           .addInterceptor(HttpBaseUrlInterceptor())     url拦截器
            .addInterceptor(ResponseInterceptor())
            .addInterceptor(loggingInterceptor)
//            .addInterceptor { chain ->
//                var request=chain.request()
//                request.newBuilder().post(RequestBody.create(MediaType.parse(
//                        "text/html;charset=GBK"),
//                    URLDecoder.decode(bodyToString(request.body()), "UTF-8")))
//                chain.proceed(request)
//            }

        //           .addInterceptor(ResponseActionIntercepter())   token失效拦截器
        val okHttpClient = builder.build()

        return  Retrofit.Builder()
            .baseUrl("https://qt.gtimg.cn/")       //主url拼接前半段
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }


    @Provides
    @Singleton
    fun provideServiceApi() : IServiceApi {
        if(!this::serviceApi.isInitialized){
            synchronized(ProvideRetrofit::class){
                if(!this::serviceApi.isInitialized){
                    if(!this::retrofit.isInitialized){
                        retrofit=createRetrofit()
                    }
                    serviceApi = retrofit.create(IServiceApi::class.java)
                }

            }
        }
        return serviceApi
    }


    private fun  bodyToString(request:RequestBody) :String{
        try {
            val copy: RequestBody  = request;
            val buffer =  Buffer()
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (e: IOException) {
            return "did not work";
        }
    }

}




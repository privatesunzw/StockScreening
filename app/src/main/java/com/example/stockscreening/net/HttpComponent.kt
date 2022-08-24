package com.example.stockscreening.net

import com.example.stockscreening.activity.OperationActivity
import com.example.stockscreening.activity.StockActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ProvideRetrofit::class, AppModule::class])
interface HttpComponent {
    fun inject( activity: StockActivity)
    fun inject( activity: OperationActivity)
}
package com.example.stockscreening.net

import okhttp3.ResponseBody
import retrofit2.Call
import javax.inject.Inject

class StockViewModel {
    var  serviceApi: IServiceApi
    @Inject
    constructor(serviceApi: IServiceApi) {
        this.serviceApi=serviceApi
    }

    fun getStock(code: String) : Call<ResponseBody> {
        return serviceApi.getStockData(code)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())

    }

}
package com.example.stockscreening.activity

import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.didi.drouter.annotation.Router
import com.example.stockscreening.BaseActivity
import com.example.stockscreening.activity.router.ActivityRouter
import com.example.stockscreening.bean.EventMessage
import com.example.stockscreening.bean.ReflectIndexToStockBean
import com.example.stockscreening.bean.StockBean
import com.example.stockscreening.bean.StockStaticData
import com.example.stockscreening.databinding.ActivityOperationBinding
import com.example.stockscreening.net.ComponentManager
import com.example.stockscreening.net.StockViewModel
import com.example.stockscreening.sqlite.SqliteDataBaseHelper
import okhttp3.ResponseBody
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@Router(path = ActivityRouter.operationActivity)
class OperationActivity : BaseActivity() {

    private lateinit var mBinding:ActivityOperationBinding
    @Inject
    lateinit var mStockViewModel: StockViewModel

    override fun getContentView():View{
        mBinding=ActivityOperationBinding.inflate(layoutInflater)
        return mBinding.root
    }


    override fun init() {
        ComponentManager.getAppComposent(this).inject(this)
        EventBus.getDefault().register(this)
        mBinding.BaseTitleBar.setBackBtnOnClickListener{onBack()}
        setOnClickListener(arrayOf(mBinding.tvClear,mBinding.tvSearch,mBinding.tvFind))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        onBack()
    }
    private fun onBack(){
        finish()
    }

    override fun onClick(view: View) {
        when(view){
            mBinding.tvClear->clear()
            mBinding.tvFind->find()
            mBinding.tvSearch-> search()
        }

        }


    private fun find(){
        val sqlite = SqliteDataBaseHelper(this, "Stock", 1)
        val arrayData = sqlite.find()
        if(arrayData.size<10){
            showToast("请耐心等待数据查询完毕")
            return
        }
        val array=arrayData.filter {it.volumeRatio.toDouble()>1&&it.riseAndFall.toDouble()>3&&it.riseAndFall.toDouble()<5&&
                it.turnoverRate.toDouble()<10&&it.turnoverRate.toDouble()>5&&it.currentMarketValue.toDouble()>50}
        var str =""
        for (data in arrayData){
            str="${str},${data.name}"
        }
        if(TextUtils.isEmpty(str)){
            mBinding.tvResult.text="没有找到匹配的结果"
        }else{
            mBinding.tvResult.text=str
        }
    }
    private fun clear(){
        val sqlite = SqliteDataBaseHelper(this, "Stock", 1)
        sqlite.clear()
    }

    private fun search(){
        for(str in StockStaticData().getStockListArray()){
            getStockData(str)
        }
    }


    private fun getStockData(code: String) {
        mStockViewModel.getStock(code).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

            }
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                showToast("数据异常")
            }
        })
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    fun eventBusListener(event: EventMessage<String>) {
        when (event.key) {
            "StockToData" -> handleStockData(event.body)
        }
    }

    private fun handleStockData(stockData: String) {
        val data = StockBean()
        val strings = stockData.split("~")
        for (i in 0..56) {
            data.setParams(ReflectIndexToStockBean.valueOfIndex(i)!!, strings[i])
            Log.e("" + ReflectIndexToStockBean.valueOfIndex(i)!!, strings[i])
        }
        Log.e("sqliteDataAdd", data.toString())
        val sqlite = SqliteDataBaseHelper(this, "Stock", 1)
        sqlite.add(data)
    }

}
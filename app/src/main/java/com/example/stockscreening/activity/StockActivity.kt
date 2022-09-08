package com.example.stockscreening.activity

import android.annotation.SuppressLint
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.didi.drouter.annotation.Router
import com.example.stockscreening.BaseActivity
import com.example.stockscreening.activity.router.ActivityRouter
import com.example.stockscreening.atapter.StockActivityAdapter
import com.example.stockscreening.bean.Condition
import com.example.stockscreening.bean.EventMessage
import com.example.stockscreening.bean.ReflectIndexToStockBean.Companion.valueOfIndex
import com.example.stockscreening.bean.StockBean
import com.example.stockscreening.bean.StockStaticData
import com.example.stockscreening.databinding.ActivityStockBinding
import com.example.stockscreening.net.ComponentManager
import com.example.stockscreening.net.StockViewModel
import com.example.stockscreening.sqlite.SqliteDataBaseHelper
import com.example.stockscreening.utils.gone
import com.example.stockscreening.utils.visible
import okhttp3.ResponseBody
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@Router(path = ActivityRouter.stockActivityPath)
class StockActivity : BaseActivity() {
    private lateinit var mBinding: ActivityStockBinding
    private val mList = mutableListOf<Condition>()
    private val mAdapter by lazy {
        StockActivityAdapter()
    }
    @Inject
    lateinit var mStockViewModel: StockViewModel

    override fun getContentView(): View {
        mBinding = ActivityStockBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun init() {
        ComponentManager.getAppComponent(this).inject(this)
        EventBus.getDefault().register(this)
        mBinding.BaseTitleBar.setBackBtnOnClickListener { onBack() }
        mAdapter.setStockActivityAdapterListener(initStockActivityAdapterListener())
        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        mList.clear()
        mList.add(Condition("条件1", "请选择条件", ""))
        mAdapter.setList(mList)
        mBinding.RVCondition.apply {
            layoutManager = llm
            adapter = mAdapter
        }
    }


    override fun onClick(view: View) {
        when (view) {

        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        onBack()
    }

    private fun onBack() {
        finish()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initStockActivityAdapterListener() =
        object : StockActivityAdapter.StockActivityAdapterListener {
            override fun addOnClick() {
                mList.add(Condition("条件${mList.size + 1}", "请选择条件", ""))
                mAdapter.notifyDataSetChanged()
            }

            override fun rlSelectOnClick() {
                mList.clear()
                mList.add(Condition("条件1", "请选择条件", ""))
                mAdapter.notifyDataSetChanged()
            }

            override fun searchOnclick() {
                for(str in StockStaticData().getStockListArray()){
                    getStockData(str)
                }
                showResult()
            }

            override fun deleteOnclick(position: Int) {
                mList.removeAt(position)
                mAdapter.notifyDataSetChanged()
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
            data.setParams(valueOfIndex(i)!!, strings[i])
            Log.e("" + valueOfIndex(i)!!, strings[i])
        }
        Log.e("sqliteDataAdd", data.toString())
        val sqlite = SqliteDataBaseHelper(this, "Stock", 1)
        sqlite.add(data)
    }

    private fun showResult(){
        val sqlite = SqliteDataBaseHelper(this, "Stock", 1)
        val arrayData = sqlite.find()
        val array=arrayData.filter {it.volumeRatio.toDouble()>1&&it.riseAndFall.toDouble()>3&&it.riseAndFall.toDouble()<5&&
                it.turnoverRate.toDouble()<10&&it.turnoverRate.toDouble()>5&&it.currentMarketValue.toDouble()>50}
        var str =""
        for (data in array){
            str="${str},${data.name}"
        }
        mBinding.RVCondition.gone()
        mBinding.tvContent.visible()
        if(TextUtils.isEmpty(str)){
            mBinding.tvContent.text="没有找到匹配的结果"
        }else{
            mBinding.tvContent.text=str
        }

    }

}
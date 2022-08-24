package com.example.stockscreening.activity

import android.annotation.SuppressLint
import android.view.View
import com.didi.drouter.annotation.Router
import com.didi.drouter.api.DRouter
import com.example.common.BaseActivity
import com.example.stockscreening.R
import com.example.stockscreening.activity.router.ActivityRouter
import com.example.stockscreening.databinding.ActivityMainBinding

@Router(path = ActivityRouter.mainActivityPath)
class MainActivity : BaseActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var mBinding: ActivityMainBinding

    override fun getContentView(): View {
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        return mBinding.root
    }

    @SuppressLint("SetTextI18n")
    override fun init() {
        mBinding.title.text = "欢迎使用${getString(R.string.app_name)}"
        mBinding.BaseTitleBar.setBackBtnOnClickListener { finish() }
        setOnClickListener(arrayOf(mBinding.title))
    }

    /**
     * 页面点击事件
     */
    override fun onClick(view: View) {
        when (view) {
            mBinding.title -> jumpToPage()

        }
    }


    override fun onRouterResult(url: String) {
        when (url) {
            ActivityRouter.stockActivityPath -> showToast("back success")
        }
    }

    /**
     * 跳转界面
     */
    private fun jumpToPage() {
        DRouter.build(ActivityRouter.operationActivity)
            .open()
    }

}


package com.example.common

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.didi.drouter.api.DRouter
import com.didi.drouter.router.Request
import com.didi.drouter.router.RouterCallback
import com.example.common.utils.ToastUtils
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BaseActivity : AppCompatActivity() {

    private lateinit var mContext: Context
    private lateinit var mActivity: Activity
    private val mDisposables by lazy { CompositeDisposable() }

    /**
     * 子类必须继承方法区
     */
    /*设置界面布局*/
    protected abstract fun getContentView(): View

    /*初始化界面*/
    protected abstract fun init()

    /*解析上个页面传过来的数据*/
    protected open fun initBundle() {}

    /*界面点击事件回调*/
    protected open fun onClick(view: View) {}

    /*跳转界面事件回调*/
    protected open fun onRouterResult(url: String) {}

    /**
     * 生命周期执行顺序区
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        mContext = this
        mActivity = this
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
        supportActionBar?.hide()
        DRouter.init(application)
        initBundle()
        init()
    }

    override fun onDestroy() {
        super.onDestroy()
        cancelToast()
        mDisposables.clear()
    }

    /**
     * 自定义方法区
     */
    /*设置view监听，与onclick一起使用*/
    fun setOnClickListener(arr: Array<View>) {
        for (view in arr) {
            view.setOnClickListener { onClick(it) }
        }
    }

    fun showToast(str: String) {
        ToastUtils.showLong(this, str)
    }

    @Suppress("public")
    fun cancelToast() {
        ToastUtils.cancelToast()
    }

    fun addDispose(disposable: Disposable?) {
        mDisposables.add(disposable)

    }

    //扩展DRouter  封装start方法的回调
    fun Request.open() {
        start(mContext, object : RouterCallback.ActivityCallback() {
            override fun onActivityResult(resultCode: Int, data: Intent?) {
                onRouterResult(uri.toString())
            }
        })
    }


}
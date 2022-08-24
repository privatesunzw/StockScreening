package com.example.stockscreening

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.didi.drouter.api.DRouter
import com.didi.drouter.router.Request
import com.didi.drouter.router.RouterCallback
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BaseActivity : AppCompatActivity() {

    private lateinit var mContext: Context
    private lateinit var mActivity: Activity
    private val mDisposables  by lazy { CompositeDisposable()}



    /**
     * 子类必须继承方法区
     */
    protected abstract fun getContentView(): View
    protected abstract fun init()
    protected open fun onClick(view: View) {}
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
        init()
    }

    override fun onDestroy() {
        super.onDestroy()
        mDisposables.clear()
    }

    /**
     * 自定义方法区
     */

    fun setOnClickListener(arr: Array<View>) {
        for (view in arr) {
            view.setOnClickListener { onClick(it) }
        }
    }

    fun showToast(str: String) {
        val toast = Toast.makeText(mContext, "", Toast.LENGTH_SHORT)
        toast.setText(str)
        toast.show()
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
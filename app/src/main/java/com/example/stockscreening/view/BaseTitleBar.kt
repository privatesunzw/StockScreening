package com.example.stockscreening.view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.example.stockscreening.R
import com.example.stockscreening.databinding.ViewBaseTitleBarBinding

open class BaseTitleBar(context: Context, attr: AttributeSet?, defStyleAttr: Int) :
    ConstraintLayout(context, attr, defStyleAttr) {

    constructor(context: Context) : this(context, null, -1)

    constructor(context: Context, attr: AttributeSet?) : this(context, attr, -1)
    var binding :ViewBaseTitleBarBinding

    init {
        val root = View.inflate(context, R.layout.view_base_title_bar, this)
        binding = ViewBaseTitleBarBinding.bind(root)

        // 由attrs 获得 TypeArray
        if (attr != null) {
            val typedArray: TypedArray =
                context.obtainStyledAttributes(attr, R.styleable.BaseTitleBar)

            for (i in 0 until typedArray.indexCount) {
                when (val itemID = typedArray.getIndex(i)) {
                    R.styleable.BaseTitleBar_titleText -> {
                        binding.tvTitle.visible()
                        binding.tvTitle.text = typedArray.getString(itemID)
                    }
                    R.styleable.BaseTitleBar_isShowLeftBtn -> {
                        binding.leftTv.visibility =
                            if (typedArray.getBoolean(itemID, false)) View.VISIBLE else View.GONE
                    }
                    R.styleable.BaseTitleBar_firstRightText -> {
                        binding.firstRightBtn.visible()
                        binding.firstRightBtn.text = typedArray.getString(itemID)
                    }
                    R.styleable.BaseTitleBar_firstRightDrawable -> {
                        binding.firstRightBtn.visible()
                        val drawable = typedArray.getDrawable(itemID)
                        drawable?.let {
                            it.setBounds()
                            binding.firstRightBtn.setCompoundDrawables(null, null, it, null)
                        }
                    }
                    R.styleable.BaseTitleBar_secondRightText -> {
                        binding.secondRightBtn.visible()
                        binding.secondRightBtn.text = typedArray.getString(itemID)
                    }
                    R.styleable.BaseTitleBar_secondRightDrawable -> {
                        val drawable = typedArray.getDrawable(itemID)
                        binding.secondRightBtn.visible()
                        drawable?.let {
                            it.setBounds()
                            binding.secondRightBtn.setCompoundDrawables(null, null, it, null)
                        }
                    }
                    R.styleable.BaseTitleBar_bottomLineVisible -> {
                        binding.bottomLineV.visibility =
                            if (typedArray.getBoolean(itemID, true)) View.VISIBLE else View.GONE
                    }
                }
            }
            typedArray.recycle()
        }

    }


    fun setTitleTv(str: String): BaseTitleBar {
        binding.tvTitle.visibility = View.VISIBLE
        binding.tvTitle.text = str
        return this
    }

    @JvmOverloads
    fun setLeftBtnAttrs(
        str: String = "",
        @ColorRes textColor: Int = R.color.color_1F2845,
        drawable: Drawable? = null,
        listener: OnClickListener,
    ): BaseTitleBar {
        binding.leftTv.apply {
            visibility = View.VISIBLE
            text = str
            setOnClickListener(listener)
            if (drawable != null) {
                drawable.setBounds()
                setCompoundDrawables(drawable, null, null, null)
            }
            setTextColor(
                ResourcesCompat.getColor(
                    context.resources,
                    textColor, null
                )
            )

        }
        return this
    }

    @JvmOverloads
    fun setSecondRightBtnAttrs(
        str: String = "",
        @ColorRes color: Int = R.color.color_1F2845,
        drawable: Drawable? = null,
        listener: OnClickListener,
    ): BaseTitleBar {
        binding.secondRightBtn.apply {
            visibility = View.VISIBLE
            text = str
            setOnClickListener(listener)
            if (drawable != null) {
                drawable.setBounds()
                setCompoundDrawables(null, null, drawable, null)
            }
            setTextColor(
                ResourcesCompat.getColor(
                    context.resources,
                    color, null
                )
            )

        }
        return this
    }

    @JvmOverloads
    fun setFirstRightBtnAttrs(
        title: String = "",
        @ColorRes color: Int = R.color.color_1F2845,
        drawable: Drawable? = null,
        listener: OnClickListener,
    ): BaseTitleBar {
        binding.firstRightBtn.apply {
            visibility = View.VISIBLE
            text = title
            setOnClickListener(listener)
            if (drawable != null) {
                drawable.setBounds()
                setCompoundDrawables(null, null, drawable, null)
            }
            setTextColor(
                ResourcesCompat.getColor(
                    context.resources,
                    color, null
                )
            )
        }
        return this
    }

    fun setMBackgroundColor(color: Int): BaseTitleBar {
        //后续用到再实现
        //todo
        return this
    }

    fun setBackBtnOnClickListener(listener: OnClickListener?): BaseTitleBar {
        setLeftBtnAttrs(
            drawable = ResourcesCompat.getDrawable(
                context.resources,
                R.mipmap.ic_base_back,
                null
            )!!,
            listener = listener!!
        )
        return this
    }

    fun Drawable.setBounds() {
        setBounds(0, 0, this.minimumWidth, this.minimumHeight)
    }

    fun View.visible() {
        visibility = View.VISIBLE
    }

    fun View.gone() {
        visibility = View.GONE
    }

}
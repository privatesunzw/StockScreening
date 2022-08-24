package com.example.stockscreening.atapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stockscreening.bean.Condition
import com.example.stockscreening.databinding.ItemActivityStockAdapterContentBinding
import com.example.stockscreening.databinding.ItemActivityStockAdbpterSubmitBinding
import com.example.stockscreening.utils.gone
import com.example.stockscreening.utils.visible

class StockActivityAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list = mutableListOf<Condition>()
    private lateinit var onClick: StockActivityAdapterListener


    inner class StockActivityContentViewHolder(binding: ItemActivityStockAdapterContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val tvConditionName = binding.tvConditionName
        val tvCondition = binding.tvCondition
        val tvConditionContent = binding.tvConditionContent
        val etConditionContent = binding.etConditionContent
        val ivAdd = binding.ivAdd
        val flRight = binding.flRight
        val tvDelete=binding.tvDelete
    }

    inner class StockActivitySubmitViewHolder(binding: ItemActivityStockAdbpterSubmitBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val tvReSelect = binding.tvReSelect
        val tvSearch = binding.tvSearch
        }

    override fun getItemViewType(position: Int): Int {
        return if (position == list.size + 1) {
            Type.Submit.index
        } else {
            Type.Content.index
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, type: Int): RecyclerView.ViewHolder {
        return if (type == Type.Submit.index) {
            StockActivitySubmitViewHolder(
                ItemActivityStockAdbpterSubmitBinding.inflate(LayoutInflater.from(
                    parent.context),
                    parent,
                    false))
        } else {
            StockActivityContentViewHolder(ItemActivityStockAdapterContentBinding.inflate(
                LayoutInflater.from(
                    parent.context),
                parent,
                false))
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getItemViewType(position)
        if (viewType == Type.Content.index) {
            holder as StockActivityContentViewHolder
            if (position == list.size) {
                isShowAdd(holder, true)
                holder.ivAdd.setOnClickListener { onClick.addOnClick() }
            } else {
                isShowAdd(holder, false)
                holder.apply {
                    tvCondition.text = "条件${position+1}"
                    tvConditionName.text = list[position].conditionName
                    tvDelete.setOnClickListener{onClick.deleteOnclick(position)}
                    if (list[position].content == "") {
                        etConditionContent.visible()
                        tvConditionContent.gone()
                    } else {
                        tvConditionContent.visible()
                        etConditionContent.gone()
                        tvConditionContent.text = list[position].content
                    }

                }
            }
        } else {
            holder as StockActivitySubmitViewHolder
            holder.tvReSelect.setOnClickListener { onClick.rlSelectOnClick() }
            holder.tvSearch.setOnClickListener { onClick.searchOnclick() }

        }

    }

    override fun getItemCount(): Int {
        return list.size + 2
    }


    fun setList(data: MutableList<Condition>) {
        list = data
        notifyDataSetChanged()
    }

    fun setStockActivityAdapterListener(onClick: StockActivityAdapterListener) {
        this.onClick = onClick
    }

    private fun isShowAdd(viewHolder: StockActivityContentViewHolder, isShow: Boolean) {
        if (isShow) {
            viewHolder.apply {
                ivAdd.visible()
                tvCondition.gone()
                tvConditionName.gone()
                flRight.gone()
                tvDelete.gone()
            }
        } else {
            viewHolder.apply {
                ivAdd.gone()
                tvCondition.visible()
                tvConditionName.visible()
                flRight.visible()
                tvDelete.visible()
            }

        }
    }

    enum class Type(val index: Int) {
        Content(100),
        Submit(101)

    }

    interface StockActivityAdapterListener {
        fun addOnClick()
        fun rlSelectOnClick()
        fun searchOnclick()
        fun deleteOnclick(position: Int)
    }


}
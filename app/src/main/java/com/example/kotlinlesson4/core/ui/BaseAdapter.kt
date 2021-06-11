package com.example.kotlinlesson4.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlesson4.model.Items

abstract class BaseAdapter<T>(
    private val holderLayoutId: Int,
) :
    RecyclerView.Adapter<BaseAdapter<T>.BaseViewHolder>() {

    var data = mutableListOf<T>()
    var listener: IBaseAdapterClickListener<T>? = null

    @JvmName("setData1")
    fun setData(data: MutableList<T>) {
        this.data = data
        notifyDataSetChanged()
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(
            LayoutInflater.from(parent.context).inflate(holderLayoutId, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(data[position], position)
    }

    abstract fun onBind(view: View, model: T, position: Int)

    inner class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(model: T, position: Int) {
            onBind(itemView, model, position)

            itemView.setOnClickListener {
                listener?.onClick(model, position)
            }
        }
    }

    interface IBaseAdapterClickListener<T> {
        fun onClick(model: T, position: Int)
    }
}
package com.example.farahal_kiswani.attendgirl.main

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.farahal_kiswani.attendgirl.R
import com.example.farahal_kiswani.attendgirl.databinding.ListRowBinding
import java.util.ArrayList

class NameAdapter : RecyclerView.Adapter<NameAdapter.DataViewHolder>() {
    private val TAG = "DataAdapter"
    private val data: MutableList<NameModel>

    init {
        this.data = ArrayList<NameModel>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
          R.layout.list_row,
            FrameLayout(parent.context), false
        )
        return DataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val dataModel = data[position]
        holder.setViewModel(NameItemViewModel(dataModel))
    }

    override fun getItemCount(): Int {
        return this.data.size
    }

    override fun onViewAttachedToWindow(holder: DataViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.bind()
    }

    override fun onViewDetachedFromWindow(holder: DataViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.unbind()
    }

    fun updateData(data: List<NameModel>?) {
        if (data == null || data.isEmpty()) {
            this.data.clear()
        } else {
            this.data.addAll(data)
        }
        notifyDataSetChanged()
    }

    class DataViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
          var binding: ListRowBinding? = null

        init {
            bind()
        }

     fun bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind<ListRowBinding>(itemView)
            }
        }

     fun unbind() {
            if (binding != null) {
                binding!!.unbind() // Don't forget to unbind
            }
        }

        /* package */  fun setViewModel(viewModel: NameItemViewModel) {
            if (binding != null) {
                binding!!.viewRow=viewModel
            }
        }
    }
}

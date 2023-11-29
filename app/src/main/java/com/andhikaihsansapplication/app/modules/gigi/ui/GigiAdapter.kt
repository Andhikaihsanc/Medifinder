package com.andhikaihsansapplication.app.modules.gigi.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.databinding.RowGigiBinding
import com.andhikaihsansapplication.app.modules.gigi.`data`.model.GigiRowModel
import kotlin.Int
import kotlin.collections.List

class GigiAdapter(
  var list: List<GigiRowModel>
) : RecyclerView.Adapter<GigiAdapter.RowGigiVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowGigiVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_gigi,parent,false)
    return RowGigiVH(view)
  }

  override fun onBindViewHolder(holder: RowGigiVH, position: Int) {
    val gigiRowModel = GigiRowModel()
    // TODO uncomment following line after integration with data source
    // val gigiRowModel = list[position]
    holder.binding.gigiRowModel = gigiRowModel
  }

  override fun getItemCount(): Int = 6
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<GigiRowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: GigiRowModel
    ) {
    }
  }

  inner class RowGigiVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowGigiBinding = RowGigiBinding.bind(itemView)
  }
}

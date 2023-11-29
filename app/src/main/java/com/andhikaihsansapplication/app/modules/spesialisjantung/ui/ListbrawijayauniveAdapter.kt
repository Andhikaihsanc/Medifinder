package com.andhikaihsansapplication.app.modules.spesialisjantung.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.databinding.RowListbrawijayauniveBinding
import com.andhikaihsansapplication.app.modules.spesialisjantung.`data`.model.ListbrawijayauniveRowModel
import kotlin.Int
import kotlin.collections.List

class ListbrawijayauniveAdapter(
  var list: List<ListbrawijayauniveRowModel>
) : RecyclerView.Adapter<ListbrawijayauniveAdapter.RowListbrawijayauniveVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListbrawijayauniveVH {
    val
        view=LayoutInflater.from(parent.context).inflate(R.layout.row_listbrawijayaunive,parent,false)
    return RowListbrawijayauniveVH(view)
  }

  override fun onBindViewHolder(holder: RowListbrawijayauniveVH, position: Int) {
    val listbrawijayauniveRowModel = ListbrawijayauniveRowModel()
    // TODO uncomment following line after integration with data source
    // val listbrawijayauniveRowModel = list[position]
    holder.binding.listbrawijayauniveRowModel = listbrawijayauniveRowModel
  }

  override fun getItemCount(): Int = 6
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ListbrawijayauniveRowModel>) {
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
      item: ListbrawijayauniveRowModel
    ) {
    }
  }

  inner class RowListbrawijayauniveVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListbrawijayauniveBinding = RowListbrawijayauniveBinding.bind(itemView)
  }
}

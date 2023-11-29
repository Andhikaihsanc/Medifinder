package com.andhikaihsansapplication.app.modules.onboardingone.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.databinding.RowListsearchBinding
import com.andhikaihsansapplication.app.modules.onboardingone.`data`.model.ListsearchRowModel
import kotlin.Int
import kotlin.collections.List

class ListsearchAdapter(
  var list: List<ListsearchRowModel>
) : RecyclerView.Adapter<ListsearchAdapter.RowListsearchVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListsearchVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listsearch,parent,false)
    return RowListsearchVH(view)
  }

  override fun onBindViewHolder(holder: RowListsearchVH, position: Int) {
    val listsearchRowModel = ListsearchRowModel()
    // TODO uncomment following line after integration with data source
    // val listsearchRowModel = list[position]
    holder.binding.listsearchRowModel = listsearchRowModel
  }

  override fun getItemCount(): Int = 3
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ListsearchRowModel>) {
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
      item: ListsearchRowModel
    ) {
    }
  }

  inner class RowListsearchVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListsearchBinding = RowListsearchBinding.bind(itemView)
  }
}

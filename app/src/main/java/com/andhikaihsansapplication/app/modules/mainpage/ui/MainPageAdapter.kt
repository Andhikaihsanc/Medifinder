package com.andhikaihsansapplication.app.modules.mainpage.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.databinding.RowMainPageBinding
import com.andhikaihsansapplication.app.modules.editprofile.ui.EditProfileActivity
import com.andhikaihsansapplication.app.modules.mainpage.`data`.model.MainPageRowModel
import com.andhikaihsansapplication.app.modules.spesialisjantung.ui.SpesialisJantungActivity
import kotlin.Int
import kotlin.collections.List

class MainPageAdapter(
  var list: List<MainPageRowModel>
) : RecyclerView.Adapter<MainPageAdapter.RowMainPageVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowMainPageVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_main_page,parent,false)
    return RowMainPageVH(view)
  }

  override fun onBindViewHolder(holder: RowMainPageVH, position: Int) {
    val mainPageRowModel = MainPageRowModel()
    // TODO uncomment following line after integration with data source
    // val mainPageRowModel = list[position]
    holder.binding.mainPageRowModel = mainPageRowModel
  }

  override fun getItemCount(): Int = 1
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<MainPageRowModel>) {
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
      item: MainPageRowModel
    ) {
    }
  }

  inner class RowMainPageVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowMainPageBinding = RowMainPageBinding.bind(itemView)
    init {
      binding.btnUser.setOnClickListener{
          val intent = Intent(itemView.context, SpesialisJantungActivity::class.java)
          intent.putExtra("CURRENT_KATEGORI", "Umum")
          itemView.context.startActivity(intent)
          Toast.makeText(itemView.context, "haiii ini adalah dokter umum", Toast.LENGTH_SHORT).show()
      }
      binding.btnTelevision.setOnClickListener {
          val intent = Intent(itemView.context, SpesialisJantungActivity::class.java)
          intent.putExtra("CURRENT_KATEGORI", "Gigi")
          itemView.context.startActivity(intent)
          Toast.makeText(itemView.context, "haiii ini adalah dokter gigi", Toast.LENGTH_SHORT).show()
      }
      binding.btnAirplane.setOnClickListener {
          val intent = Intent(itemView.context, SpesialisJantungActivity::class.java)
          intent.putExtra("CURRENT_KATEGORI", "Jantung")
          itemView.context.startActivity(intent)
          Toast.makeText(itemView.context, "haiii ini adalah dokter jantung", Toast.LENGTH_SHORT).show()
      }
    }
  }
}

//        // TODO replace with value from datasource
//        clickListener?.onItemClick(it, adapterPosition, MainPageRowModel())

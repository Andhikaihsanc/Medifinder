package com.andhikaihsansapplication.app.modules.spesialisjantung.recyclerHandler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andhikaihsansapplication.app.R

class RumahSakitAdapter(
    private val rumahSakitList: Set<RumahSakit>,
    private val clickListener: RumahSakitClickListener
) : RecyclerView.Adapter<RumahSakitAdapter.RumahSakitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RumahSakitViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_listbrawijayaunive, parent, false)
        return RumahSakitViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RumahSakitViewHolder, position: Int) {
        val currentItem = rumahSakitList.toList()[position]
        holder.textNamaRumahSakit.text = currentItem.nama
        holder.textAlamatRumahSakit.text = currentItem.alamat
        holder.textTeleponRumahSakit.text = currentItem.telepon

        holder.itemView.setOnClickListener {
            clickListener.onRumahSakitClicked(currentItem)
        }
    }

    override fun getItemCount() = rumahSakitList.size

    class RumahSakitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textNamaRumahSakit: TextView = itemView.findViewById(R.id.txtBrawijayaUnive)
        val textAlamatRumahSakit: TextView = itemView.findViewById(R.id.txtTimeZone)
        val textTeleponRumahSakit: TextView = itemView.findViewById(R.id.txt0341403000)

    }
}

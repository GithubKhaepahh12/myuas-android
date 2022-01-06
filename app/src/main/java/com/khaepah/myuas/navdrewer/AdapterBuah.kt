package com.khaepah.myuas.navdrewer

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.khaepah.myuas.R
import com.khaepah.myuas.model.DataBuah
import kotlinx.android.synthetic.main.adapter_buah.view.*
import kotlinx.android.synthetic.main.adapter_profile.view.*
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class AdapterBuah (val context: Context, var dataBuah: ArrayList<DataBuah>):
    RecyclerView.Adapter<AdapterBuah.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_buah, parent, false)
    )
    override fun getItemCount()= dataBuah.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bing(dataBuah[position])

        Glide.with(context)
            .load("http://192.168.43.224/myUAS_khaepah/public/storage/" + dataBuah[position].gambar!!)
            .centerCrop()
            .placeholder(R.color.teal_200)
            .error(R.color.teal_200)
            .into(holder.view.iv_gambar)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val view = view
        fun bing(dataBuah: DataBuah) {
            view.tv_namabuah.text = dataBuah.nama
            view.rv_status.text = dataBuah.status
            view.rv_vitamin.text = dataBuah.jenis_vitamin

        }
    }

    fun setData(newDataBuahr: List<DataBuah>){
        dataBuah.clear()
        dataBuah.addAll(newDataBuahr)
        notifyDataSetChanged()
    }
}

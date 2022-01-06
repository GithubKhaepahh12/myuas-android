package com.khaepah.myuas.navdrewer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.khaepah.myuas.R
import com.khaepah.myuas.model.DataSayur
import kotlinx.android.synthetic.main.adapter_sayur.view.*

class AdapterSayur (val context: Context, var dataSayur: ArrayList<DataSayur>):
    RecyclerView.Adapter<AdapterSayur.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_sayur, parent, false)
    )
    override fun getItemCount()= dataSayur.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bing(dataSayur[position])


        Glide.with(context)
            .load("http://192.168.43.224/myUAS_khaepah/public/storage/" + dataSayur[position].gambar!!)
            .centerCrop()
            .placeholder(R.color.teal_200)
            .error(R.color.teal_200)
            .into(holder.view.iv_gambarsayur)

    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val view = view
        fun bing(dataSayur: DataSayur) {
            view.tv_namasayur.text = dataSayur.nama
            view.rv_statussayur.text = dataSayur.status
            view.rv_vitaminsayur.text = dataSayur.jenis_vitamin

        }
    }

    fun setData(newDataSayur: List<DataSayur>){
        dataSayur.clear()
        dataSayur.addAll(newDataSayur)
        notifyDataSetChanged()
    }
}

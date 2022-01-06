package com.khaepah.myuas.navdrewer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.khaepah.myuas.R
import com.khaepah.myuas.model.DataBuah
import com.khaepah.myuas.model.DataUser
import kotlinx.android.synthetic.main.adapter_buah.view.*
import kotlinx.android.synthetic.main.adapter_profile.view.*

class AdapterProfil (val context: Context, var dataUser: ArrayList<DataUser>):
    RecyclerView.Adapter<AdapterProfil.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_profile, parent, false)
    )
    override fun getItemCount()= dataUser.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bing(dataUser[position])


        Glide.with(context)
            .load("http://192.168.43.224/myUAS_khaepah/public/storage/" + dataUser[position].gambar!!)
            .centerCrop()
            .placeholder(R.color.teal_200)
            .error(R.color.teal_200)
            .into(holder.view.imv_gambarprofil)

    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val view = view
        fun bing(dataUser: DataUser) {
            view.rv_nama.text = dataUser.name
            view.rv_email.text = dataUser.email
            view.imv_gambarprofil

        }
    }

    fun setData(newDataUser: List<DataUser>){
        dataUser.clear()
        dataUser.addAll(newDataUser)
        notifyDataSetChanged()
    }
}
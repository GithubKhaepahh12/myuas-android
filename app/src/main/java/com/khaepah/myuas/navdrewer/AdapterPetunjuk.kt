package com.khaepah.myuas.navdrewer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.khaepah.myuas.R

class AdapterPetunjuk : RecyclerView.Adapter<AdapterPetunjuk.Holder>() {

    private var nama = arrayOf(
        "Detail Profil",
        "Menu Buah sayur",
        "Menu Makanan",
        "Menu Petunjuk",
    )
    private var deskripsi = arrayOf(
        "Buka aplikasi terlebih dahulu. kemudian pilih titik 3 diatas pojok kiri. selanjutnya akan ada pilihan profil, klik menu yang bergambar profil maka akan tampil detail profil",
        "Klik titik # diatas pojok kiri, maka akan tampil navigation drawer selanjutnya pilih menu buah dan sayur kemudian akan tampil daftar nama buah sayuran beserta jenis vitaminya",
        "pilih titik 3 diatas pojok kiri. selanjutnya akan ada pilihan makanan, klik pada menu makanan maka akan tampil jenis makanan beserta manfaat proteinya",
        "Menu petunjuk berfungsi untuk menunjukan cara penggunaan aplikasi"
    )

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        var tvnama: TextView = view.findViewById(R.id.tv_nama)
        var tvDeskripsi: TextView = view.findViewById(R.id.tv_deskripsi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_petunjuk, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tvnama.text = nama[position]
        holder.tvDeskripsi.text = deskripsi[position]
    }

    override fun getItemCount(): Int {
        return nama.size
    }
}
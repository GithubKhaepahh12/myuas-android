package com.khaepah.myuas.model

import com.google.gson.annotations.SerializedName

class DataSayur(
    @SerializedName("id") val id: Long?,
    @SerializedName("nama") val nama: String?,
    @SerializedName("jenis_vitamin") val jenis_vitamin: String?,
    @SerializedName("gambar") val gambar: String?,
    @SerializedName("status") val status: String?,
)
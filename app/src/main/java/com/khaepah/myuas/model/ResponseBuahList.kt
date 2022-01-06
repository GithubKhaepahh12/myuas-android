package com.khaepah.myuas.model

import com.google.gson.annotations.SerializedName

class ResponseBuahList (
    @SerializedName("status") val status: Boolean,
    @SerializedName("msg") val msg: String,
    @SerializedName("buah") val dataBuah: List<DataBuah>
)
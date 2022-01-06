package com.khaepah.myuas.model

import com.google.gson.annotations.SerializedName

class ResponseSayurList (
    @SerializedName("status") val status: Boolean,
    @SerializedName("msg") val msg: String,
    @SerializedName("sayur") val dataSayur: List<DataSayur>
)
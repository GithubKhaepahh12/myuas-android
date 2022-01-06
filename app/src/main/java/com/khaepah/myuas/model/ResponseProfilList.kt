package com.khaepah.myuas.model

import com.google.gson.annotations.SerializedName

class ResponseProfilList (
    @SerializedName("status") val status: Boolean,
    @SerializedName("msg") val msg: String,
    @SerializedName("user") val dataUser: List<DataUser>
)
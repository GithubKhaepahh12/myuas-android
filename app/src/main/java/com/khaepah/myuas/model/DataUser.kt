package com.khaepah.myuas.model

import com.google.gson.annotations.SerializedName

class DataUser(
    @SerializedName("id") val id: Long?,
    @SerializedName("name") val name: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("gambar") val gambar: String?,
)
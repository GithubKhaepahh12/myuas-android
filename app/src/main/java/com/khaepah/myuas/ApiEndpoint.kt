package com.khaepah.myuas

import com.khaepah.myuas.model.ResponseBuahList
import com.khaepah.myuas.model.ResponseProfilList
import com.khaepah.myuas.model.ResponseSayurList
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("buah")
    fun getBuah(): Call<ResponseBuahList>

    @GET("sayur")
    fun getSayur(): Call<ResponseSayurList>

    @GET("profil")
    fun getProfil(): Call<ResponseProfilList>

}
package com.omkar.mybbshopkotlin.dataservices

import com.omkar.mybbshopkotlin.BBSettingsActivity
import com.omkar.mybbshopkotlin.model.BBClientLogin
import com.omkar.mybbshopkotlin.model.BBLoginResp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface BBData {


    companion object
    {
        val BASE_URL: String? = BBSettingsActivity.AppUrl

    }
    @POST("client/signin")
    abstract fun getLoginDetails(@Body client: BBClientLogin): Call<BBLoginResp>
}
package com.omkar.mybbshopkotlin.dataservices

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BBRetrofitclient private constructor() {
    val myApi: BBData

    init {
        val retrofit = Retrofit.Builder().baseUrl(BBData.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        myApi = retrofit.create(BBData::class.java)
    }

    companion object {

        private var instance: BBRetrofitclient? = null

        @Synchronized
        fun getInstance(): BBRetrofitclient {
            if (instance == null) {
                instance = BBRetrofitclient()
            }
            return instance as BBRetrofitclient
        }
    }

}
package com.anksmonani.kotlin.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    const val BASE_URL: String = "https://run.mocky.io/v3/"

    val mRetrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiService: APIService by lazy {

        mRetrofitBuilder
            .build()
            .create(APIService::class.java)
    }

}
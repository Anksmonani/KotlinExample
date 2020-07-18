package com.anksmonani.kotlin.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBuilder {
    const val BASE_URL: String = "https://run.mocky.io/v3/"

    private var mRetrofit: Retrofit? = null

    private fun getLogData(): HttpLoggingInterceptor? {
        val logLevel = HttpLoggingInterceptor.Level.BODY
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = logLevel
        return interceptor
    }
    var mClient = OkHttpClient.Builder().addInterceptor(getLogData()).build()

    val client: Retrofit
        get() {
            if (mRetrofit == null) {
                mRetrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(mClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return this.mRetrofit!!
        }


}
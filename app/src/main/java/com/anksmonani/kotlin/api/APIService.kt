package com.anksmonani.kotlin.api

import com.anksmonani.kotlin.models.UserListOutput
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("5eab78ac-681a-440c-b8df-8ca730cbc672")
     fun getUserList(): Call<UserListOutput>
}

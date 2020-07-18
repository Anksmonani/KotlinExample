package com.anksmonani.kotlin.api

import com.anksmonani.kotlin.models.UserListOutput
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("3bc2abd5-c605-4d7d-9304-314b49067db0")
     fun getUserList(): Call<UserListOutput>
}

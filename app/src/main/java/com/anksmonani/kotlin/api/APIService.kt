package com.anksmonani.kotlin.api

import retrofit2.http.GET

interface APIService {
    @GET("9989ba69-c232-44b4-b711-e811cd3cb3a4")
    suspend fun getUserList(): User
}

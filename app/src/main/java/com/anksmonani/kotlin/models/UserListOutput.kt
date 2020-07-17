package com.anksmonani.kotlin.models


data class UserListOutput(
    val Data: List<Data>,
    val Message: String,
    val Status: String
)

data class Data(
    val FromDate: String,
    val GuestImage: String,
    val GuestName: String,
    val PropertyName: String,
    val Status: String,
    val StatusId: String,
    val ToDate: String
)
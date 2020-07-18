package com.anksmonani.kotlin.models


data class UserListOutput(
    val Data: List<UserData>,
    val Message: String,
    val Status: String
)

data class UserData(
    val GuestImage: String,
    val GuestName: String

)
package com.example.myapplication.auth_api

import com.squareup.moshi.Json

data class LoginRequest(
    @Json(name = "email")
    val email: String,
    @Json(name = "password")
    val password: String
)

data class RegisterRequest(
    @Json(name = "email")
    val email: String,
    @Json(name = "password")
    val password: String)

data class ApiResponse(val token: String)
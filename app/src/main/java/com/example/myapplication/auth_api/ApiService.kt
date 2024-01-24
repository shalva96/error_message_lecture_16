package com.example.myapplication.auth_api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun loginUser(@Body request: LoginRequest): Response<ApiResponse>

    @POST("register")
    suspend fun registerUser(@Body request: RegisterRequest): Response<ApiResponse>
}

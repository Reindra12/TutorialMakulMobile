package com.example.tutorialpertama.data.remote

import com.example.tutorialpertama.data.remote.model.RegisterRequest
import com.example.tutorialpertama.data.remote.model.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiServiceRetrofit {
    @POST("users/")
    fun registerUser(@Body request: RegisterRequest): Call<RegisterResponse>
}
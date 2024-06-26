package com.example.tutorialpertama.data.remote

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiConfigRetrofit {
    private const val BASE_URL = "https://api.escuelajs.co/api/v1/"

    val instance: ApiServiceRetrofit by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiServiceRetrofit::class.java)
    }
}
package com.architecture.androidarchitecturestudy.webservice

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://openapi.naver.com/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(RequestInterceptor())
        .build()

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
    val NETWORK_SERVICE: NetworkService = retrofit.create(NetworkService::class.java)
}
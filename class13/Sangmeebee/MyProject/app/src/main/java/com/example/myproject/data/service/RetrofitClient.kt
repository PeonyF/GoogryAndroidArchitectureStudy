package com.example.myproject.data.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


private const val BASE_URL = "https://openapi.naver.com/v1/search/"
const val NAVER_CLIENT_ID = "Vj0ECzhoRz4wU9nrDWFB"
const val NAVER_CLIENT_SECRET = "wsAeAd6dHV"

class RetrofitClient @Inject constructor(){
    private val intercepter =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val builder = OkHttpClient.Builder()
        .addInterceptor(intercepter)
    private val okHttpClient = builder.build()

    private val retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getService(): MovieService = retrofit.create(MovieService::class.java)
}

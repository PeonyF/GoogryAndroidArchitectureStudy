package com.example.datamodule.data.network

import com.example.datamodule.data.model.ApiResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NaverMoviesApi {
    @GET("v1/search/movie.json")
    fun getMovies(@Query("query") query: String): Single<ApiResult>
}
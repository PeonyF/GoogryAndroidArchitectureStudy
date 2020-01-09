package com.cnm.homework.network

import com.cnm.homework.network.model.NaverResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NaverApi {
    @GET("v1/search/movie.json")
    fun getNaverMovie(
        @Query("query") query: String
    ): Single<NaverResponse>
}
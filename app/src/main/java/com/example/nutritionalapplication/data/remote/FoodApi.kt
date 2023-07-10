package com.example.nutritionalapplication.data.remote

import com.example.nutritionalapplication.data.response.ProductEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FoodApi {
    @GET("api/v2/search?code={barcode}")
    fun getNutritionalInformation(
        @Path("barcode") barcode: String?
    ): Call<ProductEntity?>?
}
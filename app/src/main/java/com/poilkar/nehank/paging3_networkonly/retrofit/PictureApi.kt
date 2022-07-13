package com.poilkar.nehank.paging3_networkonly.retrofit

import com.poilkar.nehank.paging3_networkonly.model.Pictures
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PictureApi {

    @GET("api/")
    suspend fun getPictures(
        @Query("page") page: Int,
        @Query("key") key : String = "22194403-66d2f5208ed5dfa2eb297ea57"
    ) :Pictures

}
package org.gsm.software.hktproject.model.users

import org.gsm.software.hktproject.model.AllPostResponse
import org.gsm.software.hktproject.model.LoginRequest
import org.gsm.software.hktproject.model.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface PostApi {
    @GET("post")
    fun getPost(
        @Header("Authorization") authorization :String,
        @Query("criterion") criterion : String,
        @Query("duration") duration : String
    ):Call<AllPostResponse>

    @POST("auth")
    fun login(
        @Body userData : LoginRequest
    ):Call<LoginResponse>

}
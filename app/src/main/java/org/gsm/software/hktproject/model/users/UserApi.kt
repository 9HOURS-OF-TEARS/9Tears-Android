package org.gsm.software.hktproject.model.users

import okhttp3.ResponseBody
import org.gsm.software.hktproject.model.LoginRequest
import org.gsm.software.hktproject.model.LoginResponse
import org.gsm.software.hktproject.model.RegisterResponse
import org.gsm.software.hktproject.model.RequestRegister
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface UserApi {

    @Headers("Accept: application/json")
    @POST("auth")
    fun login(
        @Body userData : LoginRequest
//        @Field("id") id : String,
//        @Field("password") password : String
    ):Call<LoginResponse>

    @POST("sign-up")
    fun register(
        @Body userData : RequestRegister
    ):Call<Void>

    @HEAD("check/id")
    fun idCheck(
        @Query("key") key : String
    ):Call<Void>

    @HEAD("check/nickname")
    fun nameCheck(
        @Query("key") key : String
    ):Call<Void>
}
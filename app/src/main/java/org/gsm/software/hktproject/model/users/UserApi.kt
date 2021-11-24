package org.gsm.software.hktproject.model.users

import org.gsm.software.hktproject.model.LoginRequest
import org.gsm.software.hktproject.model.LoginResponse
import org.gsm.software.hktproject.model.RegisterResponse
import org.gsm.software.hktproject.model.RequestRegister
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("sign_in")
    fun login(
        @Body userData : LoginRequest
    ):Call<LoginResponse>

    @POST("sign_up")
    fun register(
        @Body userData : RequestRegister
    ):Call<RegisterResponse>
}
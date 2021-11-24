package org.gsm.software.hktproject.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @GET("")
    fun examFun(

    ):Call<Any>

    @POST("")
    fun exam2Fun(

    ):Call<Any>

}
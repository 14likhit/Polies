package com.likhit.polis.data

import com.google.gson.JsonObject
import com.likhit.polis.data.models.Policies
import com.likhit.polis.data.models.Policy

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/policies/")
    fun getPolicy(@Body answers: JsonObject): Call<Policy>


    @POST("/policies/")
    fun getPolicies(@Body answers: JsonObject): Call<Policies>
}

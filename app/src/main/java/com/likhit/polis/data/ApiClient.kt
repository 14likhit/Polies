package com.likhit.polis.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var retrofit: Retrofit? = null

    private val base_url = "https://polies.herokuapp.com"
    //    private static final String base_url = "http://192.168.0.105:8000";

    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit
        }

}

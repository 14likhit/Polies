package com.likhit.polis.data;

import com.google.gson.JsonObject;
import com.likhit.polis.data.models.Policies;
import com.likhit.polis.data.models.Policy;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("/policies/")
    Call<Policy> getPolicy(@Body JsonObject answers);


    @POST("/policies/")
    Call<Policies> getPolicies(@Body JsonObject answers);
}

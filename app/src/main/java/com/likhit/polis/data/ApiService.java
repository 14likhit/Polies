package com.likhit.polis.data;

import com.google.gson.JsonObject;
import com.likhit.polis.data.models.Policies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("/policies/")
    Call<Policies> getPolicies(@Body JsonObject answers);
}

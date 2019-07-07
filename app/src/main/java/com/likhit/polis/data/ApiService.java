package com.likhit.polis.data;

import com.likhit.polis.data.models.Policies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/policies")
    Call<List<Policies>> getPolicies();
}

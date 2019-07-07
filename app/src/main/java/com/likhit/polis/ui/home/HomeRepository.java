package com.likhit.polis.ui.home;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.google.gson.JsonObject;
import com.likhit.polis.data.ApiClient;
import com.likhit.polis.data.ApiService;
import com.likhit.polis.data.models.Policies;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepository {

    private ApiService service = ApiClient.getRetrofitInstance().create(ApiService.class);
    private MutableLiveData<Policies> policies = new MutableLiveData<>();

    public HomeRepository() {
    }

    public MutableLiveData<Policies> getRecommendation(JsonObject answers) {
        Call<Policies> request = service.getPolicies(answers);
        request.enqueue(new Callback<Policies>() {
            @Override
            public void onResponse(@NonNull Call<Policies> call, @NonNull Response<Policies> response) {
                policies.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<Policies> call, @NonNull Throwable t) {
                policies.setValue(null);
            }
        });
        return policies;
    }
}

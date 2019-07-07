package com.likhit.polis.ui.home;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.google.gson.JsonObject;
import com.likhit.polis.data.ApiClient;
import com.likhit.polis.data.ApiService;
import com.likhit.polis.data.models.Policies;
import com.likhit.polis.data.models.Policy;
import com.likhit.polis.utils.AppConstants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepository {

    private ApiService service = ApiClient.getRetrofitInstance().create(ApiService.class);
    private MutableLiveData<Policy> policy = new MutableLiveData<>();
    private MutableLiveData<Policies> policies = new MutableLiveData<>();

    public HomeRepository() {
    }

    public MutableLiveData<Policy> getRecommendation(JsonObject answers) {
        Call<Policy> request = service.getPolicy(answers);
        request.enqueue(new Callback<Policy>() {
            @Override
            public void onResponse(@NonNull Call<Policy> call, @NonNull Response<Policy> response) {
                policy.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<Policy> call, @NonNull Throwable t) {
                policy.setValue(null);
            }
        });
        return policy;
    }

    public MutableLiveData<Policies> getPolicies() {
        JsonObject answers = new JsonObject();
        answers.addProperty(AppConstants.KEY_ANSWER_1, 1);
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

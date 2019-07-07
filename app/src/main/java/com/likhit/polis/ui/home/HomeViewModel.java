package com.likhit.polis.ui.home;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.google.gson.JsonObject;
import com.likhit.polis.data.models.Policies;
import com.likhit.polis.data.models.Policy;

public class HomeViewModel extends AndroidViewModel {

    private HomeRepository homeRepository;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        homeRepository = new HomeRepository();
    }

    public MutableLiveData<Policy> getRecommendation(JsonObject answers) {
        return homeRepository.getRecommendation(answers);
    }

    public MutableLiveData<Policies> getPolicies() {
        return homeRepository.getPolicies();
    }

}

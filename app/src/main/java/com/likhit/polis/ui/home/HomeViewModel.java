package com.likhit.polis.ui.home;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.google.gson.JsonObject;
import com.likhit.polis.data.models.Policies;

public class HomeViewModel extends AndroidViewModel {

    private HomeRepository homeRepository;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        homeRepository = new HomeRepository();
    }

    public MutableLiveData<Policies> getRecommendation(JsonObject answers) {
        return homeRepository.getRecommendation(answers);
    }

}

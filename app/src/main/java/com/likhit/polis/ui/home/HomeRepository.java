package com.likhit.polis.ui.home;

import android.arch.lifecycle.MutableLiveData;

import com.likhit.polis.data.ApiClient;
import com.likhit.polis.data.ApiService;
import com.likhit.polis.data.models.Policies;

import java.util.List;

public class HomeRepository {

    private ApiService service = ApiClient.getRetrofitInstance().create(ApiService.class);
    private MutableLiveData<List<Policies>> policies = new MutableLiveData<>();



}

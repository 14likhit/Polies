package com.likhit.polis.ui.home

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData

import com.google.gson.JsonObject
import com.likhit.polis.data.models.Policies
import com.likhit.polis.data.models.Policy

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    public val homeRepository: HomeRepository

    val policies: MutableLiveData<Policies>
        get() = homeRepository.policies

    init {
        homeRepository = HomeRepository()
    }

    fun getRecommendation(answers: JsonObject): MutableLiveData<Policy> {
        return homeRepository.getRecommendation(answers)
    }

}

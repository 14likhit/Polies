package com.likhit.polis.ui.home

import android.arch.lifecycle.MutableLiveData

import com.google.gson.JsonObject
import com.likhit.polis.data.ApiClient
import com.likhit.polis.data.ApiService
import com.likhit.polis.data.models.Policies
import com.likhit.polis.data.models.Policy
import com.likhit.polis.utils.AppConstants

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepository {

    public val service = ApiClient.retrofitInstance.create(ApiService::class.java!!)
    public val policy = MutableLiveData<Policy>()
    public val policies = MutableLiveData<Policies>()

    fun getRecommendation(answers: JsonObject): MutableLiveData<Policy> {
        val request = service.getPolicy(answers)
        request.enqueue(object : Callback<Policy> {
            override fun onResponse(call: Call<Policy>, response: Response<Policy>) {
                policy.setValue(response.body())
            }

            override fun onFailure(call: Call<Policy>, t: Throwable) {
                policy.setValue(null)
            }
        })
        return policy
    }

    fun getPolicies(): MutableLiveData<Policies> {
        val answers = JsonObject()
        answers.addProperty(AppConstants.KEY_ANSWER_1, 1)
        val request = service.getPolicies(answers)
        request.enqueue(object : Callback<Policies> {
            override fun onResponse(call: Call<Policies>, response: Response<Policies>) {
                policies.setValue(response.body())
            }

            override fun onFailure(call: Call<Policies>, t: Throwable) {
                policies.setValue(null)
            }
        })
        return policies
    }

}

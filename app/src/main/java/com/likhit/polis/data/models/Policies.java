package com.likhit.polis.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Policies implements Serializable {
    @SerializedName("policies")
    private List<Policy> policies;

    public Policies() {
    }

    public Policies(List<Policy> policies) {
        this.policies = policies;
    }

    public List<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
    }
}

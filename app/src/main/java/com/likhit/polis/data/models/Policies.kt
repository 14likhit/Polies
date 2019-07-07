package com.likhit.polis.data.models

import com.google.gson.annotations.SerializedName

import java.io.Serializable

class Policies : Serializable {
    @SerializedName("policies")
    var policies: List<Policy>? = null

    constructor() {}

    constructor(policies: List<Policy>) {
        this.policies = policies
    }
}

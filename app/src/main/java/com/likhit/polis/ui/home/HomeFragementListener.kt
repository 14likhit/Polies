package com.likhit.polis.ui.home

import com.likhit.polis.data.models.Policy

interface HomeFragementListener {

    fun launchHome()

    fun launchUserDetails()

    fun launchQA()

    fun launchRecommendations(isPolicies: Boolean)

    fun launchPolicyDetails(policy: Policy)

}

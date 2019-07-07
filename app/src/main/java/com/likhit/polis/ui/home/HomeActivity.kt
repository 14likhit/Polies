package com.likhit.polis.ui.home

import android.os.Bundle

import com.likhit.polis.R
import com.likhit.polis.base.BaseActivity
import com.likhit.polis.data.models.Policy
import com.likhit.polis.ui.detailPolicy.DetailPolicyFragment
import com.likhit.polis.ui.q_a.QandAFragment
import com.likhit.polis.ui.recommendations.RecommendationsFragment
import com.likhit.polis.ui.userdetails.UserDetailsFragment

import java.util.ArrayList

class HomeActivity : BaseActivity(), HomeFragementListener {

    private var answers: List<String>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupToolbar(getString(R.string.app_name), true)

        replaceFragment(HomeFragment.newInstance(), HomeFragment.TAG, false)
    }

    override fun launchHome() {
        replaceFragment(HomeFragment.newInstance(), HomeFragment.TAG, true)
    }

    override fun launchUserDetails() {
        replaceFragment(UserDetailsFragment.newInstance(), UserDetailsFragment.TAG, true)
    }

    override fun launchQA() {
        replaceFragment(QandAFragment.newInstance(), QandAFragment.TAG, true)
    }

    override fun launchRecommendations(isPolicies: Boolean) {
        if (answers != null && !answers!!.isEmpty() && !isPolicies) {
            val ans = arrayOf(answers!![0], answers!![1], answers!![2], answers!![3], answers!![4])
            replaceFragment(RecommendationsFragment.newInstance(ans, isPolicies), RecommendationsFragment.TAG, true)
        } else {
            val ans: Array<String> = arrayOf("Sample")
            replaceFragment(RecommendationsFragment.newInstance(ans, isPolicies), RecommendationsFragment.TAG, true)
        }
    }

    override fun launchPolicyDetails(policy: Policy) {
        replaceFragment(DetailPolicyFragment.newInstance(policy), DetailPolicyFragment.TAG, true)
    }

    fun updateAnswers(ansers: List<String>) {

        if (answers == null) {
            answers = ArrayList()
        }
        answers = ansers
    }

    companion object {

        private val TAG = "HomeActivity"
    }
}

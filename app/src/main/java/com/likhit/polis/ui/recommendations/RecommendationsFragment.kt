package com.likhit.polis.ui.recommendations

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.gson.JsonObject
import com.likhit.polis.base.BaseFragment
import com.likhit.polis.data.models.Policies
import com.likhit.polis.data.models.Policy
import com.likhit.polis.databinding.FragmentRecommendationsBinding
import com.likhit.polis.listeners.OnItemClickListener
import com.likhit.polis.ui.home.HomeFragementListener
import com.likhit.polis.ui.home.HomeViewModel
import com.likhit.polis.utils.AppConstants

import java.util.ArrayList


class RecommendationsFragment : BaseFragment(), OnItemClickListener<Policy> {

    private var binding: FragmentRecommendationsBinding? = null
    private var answers: Array<String>? = null
    private var isPolicies: Boolean? = null

    private var homeViewModel: HomeViewModel? = null
    private var adapter: PoliciesAdapter? = null

    private var policies: MutableList<Policy>? = null
    private var policiesList: Policies? = null

    private var fragementListener: HomeFragementListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            this.answers = arguments!!.getStringArray(AppConstants.BUNDLE_KEY_ANSWERS)
            this.isPolicies = arguments!!.getBoolean(AppConstants.BUNDLE_KEY_POLICIES)
        }
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is HomeFragementListener) {
            fragementListener = context
        }
    }

    override fun onDetach() {
        fragementListener = null
        super.onDetach()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRecommendationsBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java!!)
        if (isPolicies!!) {
            getPolicies()
        } else {
            getRecommendations()
        }
    }

    override fun initViews(view: View) {
        super.initViews(view)
        if (adapter == null) {
            adapter = PoliciesAdapter(this)
        }
        if (policies == null) {
            policies = ArrayList()
        }
        if (policiesList == null) {
            policiesList = Policies()
        }
        binding!!.recommendationsRv.layoutManager = LinearLayoutManager(baseActivity, LinearLayoutManager.VERTICAL, false)
        binding!!.recommendationsRv.adapter = adapter

    }

    private fun getRecommendations() {
        val answerBody = JsonObject()
        answerBody.addProperty(AppConstants.KEY_ANSWER_1, Integer.valueOf(answers!![0]))
        answerBody.addProperty(AppConstants.KEY_ANSWER_2, Integer.valueOf(answers!![1]))
        answerBody.addProperty(AppConstants.KEY_ANSWER_3, Integer.valueOf(answers!![2]))
        answerBody.addProperty(AppConstants.KEY_ANSWER_4, Integer.valueOf(answers!![3]))
        answerBody.addProperty(AppConstants.KEY_ANSWER_5, Integer.valueOf(answers!![4]))
        getRecommendation(answerBody)
    }

    private fun updateView() {
        binding!!.recommendationsIv.visibility = View.VISIBLE
        binding!!.policiesIv.visibility = View.GONE
        if (policies != null && policies!![0] != null) {
            adapter!!.setPolicies(policies)
            adapter!!.notifyDataSetChanged()
        } else {
            showMessage("Unable to connect Please try again.")
        }
    }

    private fun updatePolicies() {
        binding!!.recommendationsIv.visibility = View.GONE
        binding!!.policiesIv.visibility = View.VISIBLE
        if (policiesList != null) {
            adapter!!.setPolicies(policiesList!!.policies)
            adapter!!.notifyDataSetChanged()
        } else {
            showMessage("Unable to connect Please try again.")
        }
    }


    private fun getRecommendation(answerBody: JsonObject) {
        homeViewModel!!.getRecommendation(answerBody).observe(this, Observer { polices ->
            policies!!.add(polices)
            updateView()
        })
    }


    private fun getPolicies() {
        homeViewModel!!.policies.observe(this, Observer { policies ->
            policiesList = policies
            updatePolicies()
        })
    }


    override fun onItemClick(item: Policy, position: Int, view: View) {
        fragementListener!!.launchPolicyDetails(item)
    }

    companion object {

        val TAG = "RecommendationsFragment"

        fun newInstance(answers: Array<String>, isPolicies: Boolean): RecommendationsFragment {
            val fragment = RecommendationsFragment()
            val args = Bundle()
            args.putStringArray(AppConstants.BUNDLE_KEY_ANSWERS, answers)
            args.putBoolean(AppConstants.BUNDLE_KEY_POLICIES, isPolicies)
            fragment.arguments = args
            return fragment
        }
    }
}

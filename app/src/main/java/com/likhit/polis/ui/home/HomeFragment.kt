package com.likhit.polis.ui.home


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.likhit.polis.R
import com.likhit.polis.base.BaseFragment
import com.likhit.polis.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment() {

    private var binding: FragmentHomeBinding? = null
    private var fragementListener: HomeFragementListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun initViews(view: View) {
        super.initViews(view)
        binding!!.recommendationsLayout.setOnClickListener { fragementListener!!.launchUserDetails() }
        binding!!.policiesLayout.setOnClickListener { fragementListener!!.launchRecommendations(true) }
        binding!!.learnLayout.setOnClickListener { Toast.makeText(baseActivity, baseActivity!!.getString(R.string.coming_soon), Toast.LENGTH_SHORT).show() }
        binding!!.helpLayout.setOnClickListener { Toast.makeText(baseActivity, baseActivity!!.getString(R.string.coming_soon), Toast.LENGTH_SHORT).show() }
    }

    companion object {

        val TAG = "HomeFragment"

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}

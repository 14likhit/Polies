package com.likhit.polis.ui.detailPolicy


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.likhit.polis.R
import com.likhit.polis.base.BaseFragment
import com.likhit.polis.data.models.Policy
import com.likhit.polis.databinding.FragmentDetailPolicyBinding
import com.likhit.polis.ui.home.HomeFragementListener
import com.likhit.polis.utils.AppConstants
import com.likhit.polis.utils.Utils
import com.squareup.picasso.Picasso

class DetailPolicyFragment : BaseFragment() {

    private var binding: FragmentDetailPolicyBinding? = null
    private var policy: Policy? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            policy = arguments!!.getSerializable(AppConstants.BUNDLE_KEY_POLICY) as Policy
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailPolicyBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun initViews(view: View) {
        super.initViews(view)
        if (policy != null) {
            binding!!.policyTitleTv.text = policy!!.name
            binding!!.policyDescriptionTv.text = policy!!.detail
            val imageUrlNoParams = Utils.getUrlWithoutParameters(policy!!.image)
            Picasso.get().load(policy!!.image)
                    .stableKey(imageUrlNoParams)
                    .placeholder(R.drawable.ic_policies_24dp)
                    .fit()
                    .into(binding!!.policiesLogoIv)
        } else {
            showMessage("Unable to fetch details. Please try Again.")
        }
    }

    companion object {

        val TAG = "DetailPolicyFragment"

        fun newInstance(policy: Policy): DetailPolicyFragment {
            val fragment = DetailPolicyFragment()
            val args = Bundle()
            args.putSerializable(AppConstants.BUNDLE_KEY_POLICY, policy)
            fragment.arguments = args
            return fragment
        }
    }

}

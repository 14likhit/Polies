package com.likhit.polis.ui.detailPolicy;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.likhit.polis.R;
import com.likhit.polis.base.BaseFragment;
import com.likhit.polis.data.models.Policy;
import com.likhit.polis.databinding.FragmentDetailPolicyBinding;
import com.likhit.polis.ui.home.HomeFragementListener;
import com.likhit.polis.utils.AppConstants;
import com.likhit.polis.utils.Utils;
import com.squareup.picasso.Picasso;

public class DetailPolicyFragment extends BaseFragment {

    public static final String TAG = "DetailPolicyFragment";

    private FragmentDetailPolicyBinding binding;
    private Policy policy;

    public static DetailPolicyFragment newInstance(Policy policy) {
        DetailPolicyFragment fragment = new DetailPolicyFragment();
        Bundle args = new Bundle();
        args.putSerializable(AppConstants.BUNDLE_KEY_POLICY, policy);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            policy = (Policy) getArguments().getSerializable(AppConstants.BUNDLE_KEY_POLICY);
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDetailPolicyBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initViews(View view) {
        super.initViews(view);
        if (policy != null) {
            binding.policyTitleTv.setText(policy.getName());
            binding.policyDescriptionTv.setText(policy.getDetail());
            String imageUrlNoParams = Utils.getUrlWithoutParameters(policy.getImage());
            Picasso.get().load(policy.getImage())
                    .stableKey(imageUrlNoParams)
                    .placeholder(R.drawable.ic_policies_24dp)
                    .fit()
                    .into(binding.policiesLogoIv);
        } else {
            showMessage("Unable to fetch details. Please try Again.");
        }
    }

}

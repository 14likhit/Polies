package com.likhit.polis.ui.recommendations;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.JsonObject;
import com.likhit.polis.base.BaseFragment;
import com.likhit.polis.data.models.Policies;
import com.likhit.polis.data.models.Policy;
import com.likhit.polis.databinding.FragmentRecommendationsBinding;
import com.likhit.polis.listeners.OnItemClickListener;
import com.likhit.polis.ui.home.HomeFragementListener;
import com.likhit.polis.ui.home.HomeViewModel;
import com.likhit.polis.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;


public class RecommendationsFragment extends BaseFragment implements OnItemClickListener<Policy> {

    public static final String TAG = "RecommendationsFragment";

    private FragmentRecommendationsBinding binding;
    private String[] answers;
    private Boolean isPolicies;

    private HomeViewModel homeViewModel;
    private PoliciesAdapter adapter;

    private List<Policy> policies;
    private Policies policiesList;

    private HomeFragementListener fragementListener;

    public static RecommendationsFragment newInstance(String[] answers, boolean isPolicies) {
        RecommendationsFragment fragment = new RecommendationsFragment();
        Bundle args = new Bundle();
        args.putStringArray(AppConstants.BUNDLE_KEY_ANSWERS, answers);
        args.putBoolean(AppConstants.BUNDLE_KEY_POLICIES, isPolicies);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.answers = getArguments().getStringArray(AppConstants.BUNDLE_KEY_ANSWERS);
            this.isPolicies = getArguments().getBoolean(AppConstants.BUNDLE_KEY_POLICIES);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof HomeFragementListener) {
            fragementListener = (HomeFragementListener) context;
        }
    }

    @Override
    public void onDetach() {
        fragementListener = null;
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRecommendationsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        if (isPolicies) {
            getPolicies();
        } else {
            getRecommendations();
        }
    }

    @Override
    protected void initViews(View view) {
        super.initViews(view);
        if (adapter == null) {
            adapter = new PoliciesAdapter(this);
        }
        if (policies == null) {
            policies = new ArrayList<>();
        }
        if (policiesList == null) {
            policiesList = new Policies();
        }
        binding.recommendationsRv.setLayoutManager(new LinearLayoutManager(getBaseActivity(), LinearLayoutManager.VERTICAL, false));
        binding.recommendationsRv.setAdapter(adapter);

    }

    private void getRecommendations() {
        JsonObject answerBody = new JsonObject();
        answerBody.addProperty(AppConstants.KEY_ANSWER_1, Integer.valueOf(answers[0]));
        answerBody.addProperty(AppConstants.KEY_ANSWER_2, Integer.valueOf(answers[1]));
        answerBody.addProperty(AppConstants.KEY_ANSWER_3, Integer.valueOf(answers[2]));
        answerBody.addProperty(AppConstants.KEY_ANSWER_4, Integer.valueOf(answers[3]));
        answerBody.addProperty(AppConstants.KEY_ANSWER_5, Integer.valueOf(answers[4]));
        getRecommendation(answerBody);
    }

    private void updateView() {
        binding.recommendationsIv.setVisibility(View.VISIBLE);
        binding.policiesIv.setVisibility(View.GONE);
        if (policies != null && policies.get(0) != null) {
            adapter.setPolicies(policies);
            adapter.notifyDataSetChanged();
        } else {
            showMessage("Unable to connect Please try again.");
        }
    }

    private void updatePolicies() {
        binding.recommendationsIv.setVisibility(View.GONE);
        binding.policiesIv.setVisibility(View.VISIBLE);
        if (policiesList != null) {
            adapter.setPolicies(policiesList.getPolicies());
            adapter.notifyDataSetChanged();
        } else {
            showMessage("Unable to connect Please try again.");
        }
    }


    private void getRecommendation(JsonObject answerBody) {
        homeViewModel.getRecommendation(answerBody).observe(this, new Observer<Policy>() {
            @Override
            public void onChanged(@Nullable Policy polices) {
                policies.add(polices);
                updateView();
            }
        });
    }


    private void getPolicies() {
        homeViewModel.getPolicies().observe(this, new Observer<Policies>() {
            @Override
            public void onChanged(@Nullable Policies policies) {
                policiesList = policies;
                updatePolicies();
            }
        });
    }


    @Override
    public void onItemClick(Policy item, int position, View view) {
        fragementListener.launchPolicyDetails(item);
    }
}

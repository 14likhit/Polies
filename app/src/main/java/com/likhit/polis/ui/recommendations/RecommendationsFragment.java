package com.likhit.polis.ui.recommendations;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
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
import com.likhit.polis.databinding.FragmentRecommendationsBinding;
import com.likhit.polis.listeners.OnItemClickListener;
import com.likhit.polis.ui.home.HomeViewModel;
import com.likhit.polis.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;


public class RecommendationsFragment extends BaseFragment implements OnItemClickListener<Policies> {

    public static final String TAG = "RecommendationsFragment";

    private FragmentRecommendationsBinding binding;
    private String[] answers;

    private HomeViewModel homeViewModel;
    private PoliciesAdapter adapter;

    private List<Policies> policies;

    public static RecommendationsFragment newInstance(String[] answers) {
        RecommendationsFragment fragment = new RecommendationsFragment();
        Bundle args = new Bundle();
        args.putStringArray(AppConstants.BUNDLE_KEY_ANSWERS, answers);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.answers = getArguments().getStringArray(AppConstants.BUNDLE_KEY_ANSWERS);
        }
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
        getRecommendations();
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
        homeViewModel.getRecommendation(answerBody).observe(this, new Observer<Policies>() {
            @Override
            public void onChanged(@Nullable Policies polices) {
                policies.add(polices);
                updateView();
            }
        });
    }

    private void updateView() {
        if (policies != null && policies.get(0) != null) {
            adapter.setPolicies(policies);
            adapter.notifyDataSetChanged();
        } else {
            binding.submitProgress.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onItemClick(Policies item, int position, View view) {

    }
}

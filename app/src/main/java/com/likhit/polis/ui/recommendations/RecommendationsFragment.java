package com.likhit.polis.ui.recommendations;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.likhit.polis.base.BaseFragment;
import com.likhit.polis.databinding.FragmentRecommendationsBinding;
import com.likhit.polis.utils.AppConstants;


public class RecommendationsFragment extends BaseFragment {

    public static final String TAG = "RecommendationsFragment";

    private FragmentRecommendationsBinding binding;
    private String[] answers;

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

}

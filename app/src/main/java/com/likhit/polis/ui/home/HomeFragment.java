package com.likhit.polis.ui.home;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.likhit.polis.R;
import com.likhit.polis.base.BaseFragment;
import com.likhit.polis.databinding.FragmentHomeBinding;

public class HomeFragment extends BaseFragment {

    public static final String TAG = "HomeFragment";

    private FragmentHomeBinding binding;
    private HomeFragementListener fragementListener;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initViews(View view) {
        super.initViews(view);
        binding.recommendationsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragementListener.launchUserDetails();
            }
        });
        binding.policiesLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragementListener.launchRecommendations(true);
            }
        });
        binding.learnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseActivity(), getBaseActivity().getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();
            }
        });
        binding.helpLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseActivity(), getBaseActivity().getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.likhit.polis.ui.userdetails;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.likhit.polis.base.BaseFragment;
import com.likhit.polis.databinding.FragmentUserDetailsBinding;
import com.likhit.polis.ui.home.HomeFragementListener;

public class UserDetailsFragment extends BaseFragment {

    public static final String TAG = "UserDetailsFragment";

    private FragmentUserDetailsBinding binding;

    private HomeFragementListener fragementListener;

    public static UserDetailsFragment newInstance() {
        return new UserDetailsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentUserDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
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

    @Override
    protected void initViews(View view) {
        super.initViews(view);
//        validateDataOnFocus();
        binding.doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragementListener.launchQA();
            }
        });
    }
}

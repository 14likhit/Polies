package com.likhit.polis.ui.userdetails;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.likhit.polis.base.BaseFragment;
import com.likhit.polis.databinding.FragmentUserDetailsBinding;

public class UserDetailsFragment extends BaseFragment {

    public static final String TAG = "UserDetailsFragment";

    private FragmentUserDetailsBinding binding;

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


}

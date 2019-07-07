package com.likhit.polis.ui.q_a;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.likhit.polis.base.BaseFragment;
import com.likhit.polis.data.models.QA;
import com.likhit.polis.databinding.FragmentQandBinding;
import com.likhit.polis.utils.AppConstants;

public class QandAFragment extends BaseFragment {
    public static final String TAG = "QandAFragment";

    private FragmentQandBinding binding;
    private QA qa;

    public static QandAFragment newInstance(QA qa) {
        QandAFragment fragment = new QandAFragment();
        Bundle args = new Bundle();
        args.putSerializable(AppConstants.BUNDLE_KEY_QA, qa);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.qa = (QA) getArguments().getSerializable(AppConstants.BUNDLE_KEY_QA);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentQandBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}

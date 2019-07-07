package com.likhit.polis.ui.q_a;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.likhit.polis.base.BaseFragment;
import com.likhit.polis.data.models.QA;
import com.likhit.polis.databinding.FragmentQandBinding;
import com.likhit.polis.listeners.OnItemClickListener;
import com.likhit.polis.ui.home.HomeActivity;
import com.likhit.polis.ui.home.HomeFragementListener;
import com.likhit.polis.utils.AppConstants;
import com.likhit.polis.utils.SampleQA;

import java.util.ArrayList;
import java.util.List;

public class QandAFragment extends BaseFragment implements OnItemClickListener<String> {
    public static final String TAG = "QandAFragment";

    private FragmentQandBinding binding;
    private QA qa;
    private List<QA> qaList;
    private List<String> answers = new ArrayList<>();
    private int questionFinished = 0;
    private AnswersAdapter answersAdapter;

    private HomeFragementListener fragementListener;
    private HomeActivity homeActivity;

    public static QandAFragment newInstance() {
        return new QandAFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.qa = (QA) getArguments().getSerializable(AppConstants.BUNDLE_KEY_QA);
        }
        SampleQA.setQA();
        qaList = SampleQA.getQas();
        homeActivity = (HomeActivity) getActivity();
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
        binding = FragmentQandBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initViews(View view) {
        super.initViews(view);
        if (answersAdapter == null) {
            answersAdapter = new AnswersAdapter(this);
        }
        binding.answersRv.setLayoutManager(new LinearLayoutManager(getBaseActivity(), LinearLayoutManager.VERTICAL, false));
        binding.answersRv.setAdapter(answersAdapter);
        updateView();
    }

    private void updateView() {
        qa = qaList.get(questionFinished);
        binding.questionsTv.setText(qa.getQuestion());
        answersAdapter.setAnswers(qa.getAnswers());
        answersAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(String item, int position, View view) {
        questionFinished++;
        answers.add(Integer.toString(position + 1));
        homeActivity.updateAnswers(answers);
        if (questionFinished == qaList.size()) {
            fragementListener.launchRecommendations(false);
            questionFinished = 0;
        } else {
            updateView();
        }

    }
}

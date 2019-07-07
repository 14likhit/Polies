package com.likhit.polis.ui.home;

import android.os.Bundle;

import com.likhit.polis.R;
import com.likhit.polis.base.BaseActivity;
import com.likhit.polis.ui.q_a.QandAFragment;
import com.likhit.polis.ui.recommendations.RecommendationsFragment;
import com.likhit.polis.ui.userdetails.UserDetailsFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity implements HomeFragementListener {

    private static final String TAG = "HomeActivity";

    private List<String> answers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupToolbar(getString(R.string.app_name), true);

        replaceFragment(HomeFragment.newInstance(), HomeFragment.TAG, false);
    }

    @Override
    public void launchHome() {
        replaceFragment(HomeFragment.newInstance(), HomeFragment.TAG, false);
    }

    @Override
    public void launchUserDetails() {
        replaceFragment(UserDetailsFragment.newInstance(), UserDetailsFragment.TAG, false);
    }

    @Override
    public void launchQA() {
        replaceFragment(QandAFragment.newInstance(), QandAFragment.TAG, false);
    }

    @Override
    public void launchRecommendations() {
        if (answers != null && !answers.isEmpty()) {
            String[] ans = {answers.get(0), answers.get(1), answers.get(2), answers.get(3), answers.get(4)};
            replaceFragment(RecommendationsFragment.newInstance(ans), RecommendationsFragment.TAG, false);
        } else {
            String[] ans = null;
            replaceFragment(RecommendationsFragment.newInstance(ans), RecommendationsFragment.TAG, false);
        }
    }

    public void updateAnswers(List<String> ansers) {

        if (answers == null) {
            answers = new ArrayList<>();
        }
        answers = ansers;
    }
}

package com.likhit.polis.ui.home;

import com.likhit.polis.data.models.Policy;

public interface HomeFragementListener {

    void launchHome();

    void launchUserDetails();

    void launchQA();

    void launchRecommendations();

    void launchPolicyDetails(Policy policy);

}

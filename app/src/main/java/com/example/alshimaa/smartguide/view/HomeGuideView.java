package com.example.alshimaa.smartguide.view;

import com.example.alshimaa.smartguide.model.FollowFlightsData;

import java.util.List;

public interface HomeGuideView {
    void showHomeGuideList(List<FollowFlightsData> followFlightsDataList);
    void showHomeGuideError();
}

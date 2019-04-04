package com.example.alshimaa.smartguide.view;

import com.example.alshimaa.smartguide.model.FollowFlightsData;

import java.util.List;

public interface FollowFlightsView {
    void showFollowFlightsList(List<FollowFlightsData> followFlightsDataList);
    void showFollowFlightsError();
}
